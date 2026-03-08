package com.mqz.dto.response;

import java.math.BigDecimal;

public record TransactionResponse(Long id, Long accountId, Long recipientId, BigDecimal amount) {
}
