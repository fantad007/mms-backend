package com.mms.entity.connection;

import com.mms.entity.CategoryEntity;
import com.mms.entity.WalletEntity;
import com.mms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_category_wallet")
public class CategoryWalletEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private WalletEntity wallet;

    private BigDecimal amount;

    @Column(columnDefinition = "nvarchar(255)")
    private String description;

    private Date atTime;
}
