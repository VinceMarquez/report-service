package com.mqz.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "transaction-service")
@Data
public class TransactionServiceConfiguration {

    private String baseUrl;

    private String getTransaction;

}
