package com.sirheadless.mybookmarks.category.service;

import com.sirheadless.mybookmarks.category.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    List<Category> getAllCategoriesByUserId(int userId);

    Category getCategoryById(int categoryId);

    boolean addCategory(Category category);

    void deleteCategory(int categoryId);
}
