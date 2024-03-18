package com.mms.service.impl;

import com.mms.dto.CategoryDto;
import com.mms.entity.CategoryEntity;
import com.mms.repository.CategoryRepository;
import com.mms.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplCategoryService implements CategoryService {

    private final ModelMapper mapper;

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryEntity> categories = categoryRepository.getAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        if (!categories.isEmpty()) {
            for (CategoryEntity category: categories) {
                CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
                categoryDto.setTypeName(categoryDto.getType().getName());
                categoryDtos.add(categoryDto);
            }
            return categoryDtos;
        }
        return null;
    }

    @Override
    public CategoryDto getById(Long id) {
        if (categoryRepository.getCategoryById(id).isPresent()) {
            CategoryDto categoryDto = mapper.map(categoryRepository.getCategoryById(id).get(), CategoryDto.class);
            categoryDto.setTypeName(categoryDto.getType().getName());
            return categoryDto;
        }
        return null;
    }

    @Override
    @Transactional
    public CategoryDto create(CategoryDto categoryDto) {
        CategoryEntity category = mapper.map(categoryDto, CategoryEntity.class);
        category.setAmount(BigDecimal.valueOf(0));
        categoryRepository.saveAndFlush(category);
        categoryDto = mapper.map(category, CategoryDto.class);
        categoryDto.setTypeName(categoryDto.getType().getName());
        return categoryDto;
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto categoryDto, Long id) {
        return categoryDto;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        CategoryEntity category = mapper.map(getById(id), CategoryEntity.class);
        category.setDeleted(true);
        categoryRepository.saveAndFlush(category);
    }
}
