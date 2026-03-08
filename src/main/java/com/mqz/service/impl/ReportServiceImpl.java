package com.mqz.service.impl;

import com.mqz.api.AccountServiceApiClient;
import com.mqz.api.TransactionServiceApiClient;
import com.mqz.dto.response.AccountResponse;
import com.mqz.dto.response.ReportResponse;
import com.mqz.dto.response.TransactionResponse;
import com.mqz.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    private final AccountServiceApiClient accountServiceApiClient;

    private final TransactionServiceApiClient transactionServiceApiClient;

    @Override
    public Mono<ReportResponse> getAccountSingleTransaction(Long accountId, Long transactionId) {
        logger.info("[ReportServiceImpl.getAccountSingleTransaction] Getting Account ID: {}, Transaction ID: {}", accountId, transactionId);
        Mono<AccountResponse> accountMono = accountServiceApiClient.getAccountById(accountId);
        Mono<TransactionResponse> transactionMono = transactionServiceApiClient.getTransactionById(transactionId);

        return Mono.zip(accountMono, transactionMono)
                .map(tuple -> new ReportResponse(
                        tuple.getT1(),
                        tuple.getT2()
                ));
    }

}
