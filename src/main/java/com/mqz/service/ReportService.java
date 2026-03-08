package com.mqz.service;

import com.mqz.dto.response.AccountResponse;

public interface ReportService {

    AccountResponse getAccountSingleTransaction(Long accountId, Long transactionId);

}
