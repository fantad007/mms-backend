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
public class WalletDto {

    private Long id;

    private String name;

    private BigDecimal balance;

    private String createdBy;

    private String updatedBy;

    private Date createdAt;

    private Date updatedAt;
}
