package com.sirheadless.mybookmarks.category.service;

import java.util.List;

import com.sirheadless.mybookmarks.category.entity.CategoryEntity;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();
	CategoryEntity getCategoryById(int categoryEntityId);
    boolean addCategory(CategoryEntity categoryEntity);
    void updateCategory(CategoryEntity categoryEntity);
    void deleteCategory(int categoryEntityId);
}
