package com.mms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long walletId;

    private Long categoryId;

    private String categoryName;

    private String typeName;

    private BigDecimal amount;

    private String description;

    private Date atTime;
}
