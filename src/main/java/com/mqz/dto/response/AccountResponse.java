package com.mqz.dto.response;

import java.time.LocalDate;

public record AccountResponse(Long id, String name, LocalDate birthDate) {
}
