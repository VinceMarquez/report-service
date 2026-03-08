package com.mqz.dto.response;

import java.math.BigDecimal;

public record ReportResponse(AccountResponse account, TransactionResponse transaction) {
}
