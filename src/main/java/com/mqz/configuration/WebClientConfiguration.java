package com.mqz.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {

    @Bean
    public WebClient accountServiceWebClient(WebClient.Builder builder, AccountServiceConfiguration accountServiceConfiguration) {
        return builder.baseUrl(accountServiceConfiguration.getBaseUrl()).build();
    }

    @Bean
    public WebClient transactionServiceWebClient(WebClient.Builder builder, TransactionServiceConfiguration transactionServiceConfiguration) {
        return builder.baseUrl(transactionServiceConfiguration.getBaseUrl()).build();
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
