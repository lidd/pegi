package com.youon.pegi.nj.core;

import com.youon.pegi.nj.constants.NJTypeBodyHandlerBinder;
import com.youon.pegi.nj.domain.frame.NJBody;
import com.youon.pegi.nj.domain.frame.NJFrame;
import com.youon.pegi.nj.domain.frame.NJResp;
import com.youon.pegi.nj.infrastructure.BizHandler;
import com.youon.pegi.nj.support.JsonUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Li dong
 */

@Component
public class NJFrameResolver extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ApplicationContext context;

    @Resource
    private NJChannelHolder holder;

    @Override
    public boolean isSharable() {
        return true;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            if (msg instanceof NJFrame) {

                int type = ((NJFrame) msg).getHead().getFrameType();

                NJTypeBodyHandlerBinder binder = NJTypeBodyHandlerBinder.findBinder(type);

                if (binder != null) {
                    NJBody body = JsonUtil.fromJson(((NJFrame) msg).getBody(), binder.getBodyClass());

                    holder.register(body.getTermId(), ctx.channel());

                    BizHandler handler = context.getBean(binder.getHandlerClass());
                    NJResp resp = handler.handle(body);

                    if (resp != null) {
                        ctx.channel().writeAndFlush(resp);
                    }
                }
            }
        } catch (Throwable e) {
            logger.error(e.getMessage());
        }
    }
}
