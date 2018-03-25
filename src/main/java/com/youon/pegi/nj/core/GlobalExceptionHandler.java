package com.youon.pegi.nj.core;

import com.youon.pegi.nj.boot.Server;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Li dong
 */

@Component
public class GlobalExceptionHandler extends ChannelDuplexHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private Server server;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //netty internal error occurs.
        if (!cause.getMessage().contains("Connection reset by peer")) {
            logger.error(">>>> FATAL :{}", cause);
            server.restart();
        }
    }

    @Override
    public boolean isSharable() {
        return true;
    }
}
