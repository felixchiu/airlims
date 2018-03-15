package com.airlims.enterprise.applications.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by Felix Chiu on 3/14/18.
 */
@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "auditLogExecutor")
    public Executor auditLogExecutor() {
        log.info("Building audit log executor");
        return new ThreadPoolTaskExecutor();
    }

    @Bean(name = "messageLogExecutor")
    public Executor messageLogExecutor() {
        log.info("Building message log executor");
        return new ThreadPoolTaskExecutor();
    }


}