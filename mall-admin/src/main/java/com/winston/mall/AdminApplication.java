package com.winston.mall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AdminApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(" ===Admin application startUp successful! ===");
    }
}
