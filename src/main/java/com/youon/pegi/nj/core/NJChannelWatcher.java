package com.youon.pegi.nj.core;

import com.youon.pegi.nj.domain.frame.NJBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Li dong
 */

@Component
public class NJChannelWatcher extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NJChannelHolder holder;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("client :{} connected.", ctx.channel().remoteAddress());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("client :{} disconnected.", ctx.channel().remoteAddress());
        }
        holder.unregister(ctx.channel());
    }

    @Override
    public boolean isSharable() {
        return true;
    }
}
