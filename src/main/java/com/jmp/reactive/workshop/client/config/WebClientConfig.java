package com.jmp.reactive.workshop.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 04/07/2022
 */
@Configuration
public class WebClientConfig {

    @Value("${web-client.baseUrl}")
    private String baseUrl;

    @Bean
    public WebClient sportsAPIClient() {
        return WebClient
                .builder()
                .baseUrl(baseUrl)
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(8 * 1024 * 1024))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
