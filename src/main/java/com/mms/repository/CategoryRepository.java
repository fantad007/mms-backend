package com.mms.repository;

import com.mms.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query(value = "SELECT * FROM _category c WHERE c.is_deleted = 0", nativeQuery = true)
    List<CategoryEntity> getAll();

    @Query(value = "SELECT * FROM _category c WHERE c.id = :id AND c.is_deleted = 0", nativeQuery = true)
    Optional<CategoryEntity> getCategoryById(Long id);

    @Query(value = "SELECT SUM(c.amount) FROM _category c WHERE c.type = 1 AND c.is_deleted = 0", nativeQuery = true)
    BigDecimal getTotalSpend();

    @Query(value = "SELECT SUM(c.amount) FROM _category c WHERE c.type = 0 AND c.is_deleted = 0", nativeQuery = true)
    BigDecimal getTotalEarn();
}