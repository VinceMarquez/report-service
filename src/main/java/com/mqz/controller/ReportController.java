package com.mqz.controller;

import com.mqz.dto.response.AccountResponse;
import com.mqz.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity<AccountResponse> getAccountSingleTransaction(@RequestParam("accountId") Long accountId,
                                                                       @RequestParam("transactionId") Long transactionId) {
        logger.info("Received getAccountSingleTransaction request with Params: [accountId = {}, transactionId = {}", accountId, transactionId);
        return ResponseEntity.ok(reportService.getAccountSingleTransaction(accountId, transactionId));
    }

}
