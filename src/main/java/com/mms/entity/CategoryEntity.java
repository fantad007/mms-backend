package com.mms.entity;

import com.mms.entity.base.BaseAuditEntity;
import com.mms.entity.connection.CategoryWalletEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_category")
public class CategoryEntity extends BaseAuditEntity {

    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    private BigDecimal amount;

    private TransactionType type;

    private boolean isDeleted = false;

    @OneToMany(mappedBy = "category")
    private Set<CategoryWalletEntity> categoryWallets = new HashSet<>();
}
