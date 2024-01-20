package com.scaler.productservice.controllers;

import com.scaler.productservice.exception.CateggoryNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(@Qualifier("selfCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{name}")
    public Category getCategoryByName(@PathVariable("name") String name) throws CateggoryNotFoundException {
        return categoryService.getSingleCategory(name);
    }

}
