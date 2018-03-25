package com.youon.pegi.nj.core;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Li dong
 */

@Component
public class NJChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private NJFrameResolver njFrameResolver;

    @Resource
    private GlobalExceptionHandler globalExceptionHandler;

    @Resource
    private ApplicationContext context;

    @Resource
    private NJChannelWatcher frameWatcher;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        NJFrameDecoder decoder = context.getBean(NJFrameDecoder.class);
        NJFrameEncoder encoder = context.getBean(NJFrameEncoder.class);
        ch.pipeline()
                .addLast(decoder)
                .addLast(frameWatcher)
                .addLast(njFrameResolver)
                .addLast(encoder)
                .addLast(globalExceptionHandler);
    }
}
