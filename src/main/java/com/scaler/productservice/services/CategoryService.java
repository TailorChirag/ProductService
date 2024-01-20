package com.scaler.productservice.services;

import com.scaler.productservice.exception.CateggoryNotFoundException;
import com.scaler.productservice.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category getSingleCategory(String name) throws CateggoryNotFoundException;
}
