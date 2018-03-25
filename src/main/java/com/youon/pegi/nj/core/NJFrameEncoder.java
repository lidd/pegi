package com.youon.pegi.nj.core;

import com.youon.pegi.nj.domain.frame.NJResp;
import com.youon.pegi.nj.support.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Li dong
 */

@Component
public class NJFrameEncoder extends MessageToByteEncoder<NJResp> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void encode(ChannelHandlerContext ctx, NJResp msg, ByteBuf out) {
        try {
            if (msg != null)
                out.writeBytes(JsonUtil.toJson(msg).getBytes(CharsetUtil.UTF_8));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean isSharable() {
        return true;
    }
}
