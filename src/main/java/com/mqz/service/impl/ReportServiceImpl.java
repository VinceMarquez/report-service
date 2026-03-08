package com.mqz.service.impl;

import com.mqz.api.AccountServiceApiClient;
import com.mqz.api.TransactionServiceApiClient;
import com.mqz.dto.response.AccountResponse;
import com.mqz.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    private final AccountServiceApiClient accountServiceApiClient;

    private final TransactionServiceApiClient transactionServiceApiClient;

    @Override
    public AccountResponse getAccountSingleTransaction(Long accountId, Long transactionId) {
        logger.info("[ReportServiceImpl.getAccountSingleTransaction] Getting Account ID: {}, Transaction ID: {}", accountId, transactionId);
        logger.info("[ReportServiceImpl.getAccountSingleTransaction] {}", transactionServiceApiClient.getTransactionById(transactionId));
        return accountServiceApiClient.getAccountById(accountId);
    }

}
