package com.sirheadless.mybookmarks.category.service;

import java.util.List;

import com.sirheadless.mybookmarks.category.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();
	Category getCategoryById(int categoryId);
    boolean addCategory(Category category);
    void deleteCategory(int categoryId);
}
