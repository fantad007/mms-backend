package com.mms.service;

import com.mms.dto.CategoryDto;

import java.math.BigDecimal;
import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();

    CategoryDto getById(Long id);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto, Long id);

    void delete(Long id);

    BigDecimal getTotalSpend();

    BigDecimal getTotalEarn();
}
