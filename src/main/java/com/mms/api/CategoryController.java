package com.mms.api;

import com.mms.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories/total-spend")
    public BigDecimal getTotalSpend() {
        return categoryService.getTotalSpend();
    }

    @GetMapping("/categories/total-earn")
    public BigDecimal getTotalEarn() {
        return categoryService.getTotalEarn();
    }
}
