package com.mqz.service;

import com.mqz.dto.response.ReportResponse;
import reactor.core.publisher.Mono;

public interface ReportService {

    Mono<ReportResponse> getAccountSingleTransaction(Long accountId, Long transactionId);

}
