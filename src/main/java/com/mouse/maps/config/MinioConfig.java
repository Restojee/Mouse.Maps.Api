package com.mouse.maps.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MinioConfig {

    @Bean
    MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("http://172.28.236.95:9000/")
                .credentials("minio", "rootroot")
                .build();
    }
}
