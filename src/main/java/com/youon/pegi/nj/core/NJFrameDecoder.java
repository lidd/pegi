package com.youon.pegi.nj.core;

import com.youon.pegi.nj.domain.frame.NJFrame;
import com.youon.pegi.nj.domain.frame.NJHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Arrays;

/**
 * @author Li dong
 */

@Component
@Scope("prototype")
public class NJFrameDecoder extends LengthFieldBasedFrameDecoder {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public NJFrameDecoder() {
        super(8192, 0, 2);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }

        int frameLength = frame.readUnsignedShort();
        frame.markReaderIndex();
        int headLength = 16;
        int macLength = 8;
        int bodyLength = frameLength - (headLength + macLength);

        byte[] headAndBody = new byte[headLength + bodyLength];
        frame.readBytes(headAndBody);
        byte[] mac = new byte[macLength];
        frame.readBytes(mac);
        byte[] calcMac = DigestUtils.md5Digest(headAndBody);
        //校验 mac
        if (Arrays.equals(mac, Arrays.copyOfRange(calcMac, 4, 12))) {

            frame.resetReaderIndex();

            NJHeader njHeader = new NJHeader();
            njHeader.setFrameType(frame.readUnsignedShort());
            njHeader.setPosId(frame.readUnsignedInt());
            njHeader.setSessionId(frame.readUnsignedInt());
            njHeader.setFrameId(frame.readUnsignedShort());
            njHeader.setLastFlag(frame.readUnsignedByte());
            njHeader.setFrameCnt(frame.readShort());
            njHeader.setCheckMac(frame.readByte());
            byte[] body = new byte[bodyLength];
            frame.readBytes(body);
            NJFrame njFrame = new NJFrame();
            njFrame.setBody(new String(body, CharsetUtil.UTF_8));
            njFrame.setLength(frameLength);
            njFrame.setHead(njHeader);

            if (logger.isDebugEnabled()) {
                logger.debug(njFrame.getBody());
            }

            return njFrame;
        } else {
            in.discardReadBytes();
            return null;
        }
    }

    @Override
    public boolean isSharable() {
        return false;
    }
}
