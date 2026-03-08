package com.mqz.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "account-service")
@Data
public class AccountServiceConfiguration {

    private String baseUrl;

    private String getAccount;

}
