package com.scaler.productservice.services;

import com.scaler.productservice.exception.CateggoryNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{

    private CategoryRepository categporyRepository;

    public SelfCategoryService(CategoryRepository categporyRepository) {
        this.categporyRepository = categporyRepository;
    }

    @Override
    public List<Category> getAllCategory() {

        return categporyRepository.findAll();
    }

    @Override
    public Category getSingleCategory(String name) throws CateggoryNotFoundException {
        Optional<Category> optionalCategory = categporyRepository.findByName(name);

        if(optionalCategory.isEmpty()){
            throw new CateggoryNotFoundException("Category with name " + name + " not found");
        }

        Category category = optionalCategory.get();
        return category;
    }
}
