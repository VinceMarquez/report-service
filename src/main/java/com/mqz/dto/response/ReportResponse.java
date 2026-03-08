package com.mqz.dto.response;

import java.math.BigDecimal;

public record ReportResponse(Long accountId, Long recipientId, Long transactionId, BigDecimal amount) {
}
