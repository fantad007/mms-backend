package com.mms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionType {
    INCOME("Thu", "Số tiền được cộng vào ví"),
    EXPENDITURE("Chi", "Số tiền bị trừ khỏi ví");

    private final String name;

    private final String description;

    @Override
    public String toString() {
        return name + ":" + description;
    }
}
