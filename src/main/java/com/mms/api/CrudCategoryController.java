package com.mms.api;

import com.mms.dto.CategoryDto;
import com.mms.exception.ObjectNotFoundException;
import com.mms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrudCategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/category/{id}")
    public CategoryDto getById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getById(id);
        if (categoryDto == null) {
            throw new ObjectNotFoundException("Not found entity with id = " + id);
        }
        return categoryDto;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        CategoryDto newCategory = categoryService.create(categoryDto);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto, @PathVariable Long id) {
        CategoryDto editCategory = categoryService.update(categoryDto, id);
        return new ResponseEntity<>(editCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
