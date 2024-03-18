package com.mms.repository;

import com.mms.entity.connection.CategoryWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryWalletRepository extends JpaRepository<CategoryWalletEntity, Long> {
}