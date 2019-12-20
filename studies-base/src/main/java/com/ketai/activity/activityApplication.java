package com.ketai.activity;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Childe Liao
 * @since 2019/12/20
 */
@SpringBootApplication
public class activityApplication {

    public static void main(String[] args) {
        SpringApplication.run(activityApplication.class);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
