package com.youon.pegi.nj.boot;

import com.youon.pegi.nj.core.NJChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Li dong
 */
@Component
public class Server {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${pegi.port}")
    private int port;

    private ServerBootstrap bootstrap;

    private EventLoopGroup boss;
    private EventLoopGroup worker;

    @Resource
    private NJChannelInitializer channelInitializer;

    /**
     * 0.ready to start
     * 1.running
     * 2.ready to shutdown
     * 3.dead
     */

    private final int READY_START = 0;

    private final int RUNNING = 1;

    private final int READY_SHUTDOWN = 2;

    private final int DEAD = 3;

    private volatile int state;

    public void start() {
        try {
            if (state == RUNNING) {
                return;
            }
            state = READY_START;
            Optional<ServerBootstrap> optionalBootstrap = Optional.ofNullable(bootstrap);
            bootstrap = optionalBootstrap.orElse(init());
            ChannelFuture future = bootstrap.bind(port).sync();
            if (future.isSuccess()) {
                state = RUNNING;
                logger.info("<<<<<<<<<<<<<<<<<<<<");
                logger.info("<<<< PEGI RUNS. <<<<");
                logger.info("<<<<<<<<<<<<<<<<<<<<");
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("fail start:{}", e);
        } finally {
            shutdownGracefully();
        }
    }


    @PostConstruct
    private ServerBootstrap init() {
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_REUSEADDR, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(channelInitializer);
        return bootstrap;
    }

    public synchronized void shutdownGracefully() {
        if (state < READY_SHUTDOWN) {
            state = READY_SHUTDOWN;
            logger.info(">>>>  Shutdown PEGI. >>>>");
            worker.shutdownGracefully();
            boss.shutdownGracefully();
            state = DEAD;
        }
    }

    public void restart() {
        shutdownGracefully();
        start();
    }
}
