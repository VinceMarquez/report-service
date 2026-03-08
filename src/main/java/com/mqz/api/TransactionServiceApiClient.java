package com.mqz.api;

import com.mqz.configuration.AccountServiceConfiguration;
import com.mqz.configuration.TransactionServiceConfiguration;
import com.mqz.dto.response.AccountResponse;
import com.mqz.dto.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class TransactionServiceApiClient {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceApiClient.class);

    private final TransactionServiceConfiguration transactionServiceConfiguration;

    private final WebClient transactionServiceWebClient;

    public TransactionResponse getTransactionById(Long id) {
        logger.info("[TransactionServiceApiClient.getTransactionById] Getting Transaction ID: {} from Transaction Service", id);
        return transactionServiceWebClient
                .get()
                .uri(transactionServiceConfiguration.getGetTransaction(), id)
                .retrieve()
                .bodyToMono(TransactionResponse.class)
                .block();
    }

}
