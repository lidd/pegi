package com.youon.pegi.nj.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 处理通过FTP上传的文件
 *
 * @author Li Dong
 */

@Component
@EnableScheduling
public class FtpFileCollectTask {



    @Scheduled(fixedRate = 5000)
    public void execute() {
        System.out.println(LocalDateTime.now());
    }
}
