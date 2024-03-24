package com.mms.repository;

import com.mms.entity.connection.CategoryWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryWalletRepository extends JpaRepository<CategoryWalletEntity, Long> {

    @Query(value = "SELECT * FROM _category_wallet cw WHERE cw.is_deleted = 0 ORDER BY cw.at_time DESC", nativeQuery = true)
    List<CategoryWalletEntity> getAll();

    @Query(value = "SELECT * FROM _category_wallet cw WHERE cw.id = :id AND cw.is_deleted = 0", nativeQuery = true)
    Optional<CategoryWalletEntity> getTransactionById(Long id);
}