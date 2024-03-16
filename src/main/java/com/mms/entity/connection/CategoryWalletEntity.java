package com.mms.entity.connection;

import com.mms.entity.CategoryEntity;
import com.mms.entity.WalletEntity;
import com.mms.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

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
}
