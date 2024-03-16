package com.mms.repository;

import com.mms.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    @Query(value = "SELECT * FROM _wallet w WHERE w.is_deleted = 0", nativeQuery = true)
    List<WalletEntity> getAll();

    @Query(value = "SELECT * FROM _wallet w WHERE w.id = :id AND w.is_deleted = 0", nativeQuery = true)
    Optional<WalletEntity> getWalletById(Long id);

    @Query(value = "SELECT SUM(w.balance) AS TOTAL_BALANCE FROM _wallet w WHERE w.is_deleted = 0", nativeQuery = true)
    BigDecimal getTotalBalance();
}