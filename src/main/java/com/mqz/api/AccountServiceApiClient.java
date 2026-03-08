package com.mqz.api;

import com.mqz.configuration.AccountServiceConfiguration;
import com.mqz.dto.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountServiceApiClient {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceApiClient.class);

    private final AccountServiceConfiguration accountServiceConfiguration;

    private final WebClient accountServiceWebClient;

    public Mono<AccountResponse> getAccountById(Long id) {
        logger.info("[AccountServiceApiClient.getAccountById] Getting Account ID: {} from Account Service", id);
        return accountServiceWebClient
                .get()
                .uri(accountServiceConfiguration.getGetAccount(), id)
                .retrieve()
                .bodyToMono(AccountResponse.class);
    }

}
