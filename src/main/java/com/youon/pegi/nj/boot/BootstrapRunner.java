package com.youon.pegi.nj.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Li dong
 */

@Component
public class BootstrapRunner implements CommandLineRunner {

    @Resource
    private Server server;

    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.shutdownGracefully()));
        server.start();
    }
}
