package com.mms.dto;

import com.mms.entity.TransactionType;
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
public class CategoryDto {

    private Long id;

    private String name;

    private BigDecimal amount;

    private TransactionType type;

    private String typeName;

    private String createdBy;

    private String updatedBy;

    private Date createdAt;

    private Date updatedAt;
}
