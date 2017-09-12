package com.sirheadless.mybookmarks.category.dao;

import java.util.List;

import com.sirheadless.mybookmarks.category.entity.CategoryEntity;

public interface CategoryDAO {
	List<CategoryEntity> getAllCategories();
	CategoryEntity getCategoryEntityById(int categoryEntityId);
    void addCategory(CategoryEntity categoryEntity);
    void updateCategory(CategoryEntity categoryEntity);
    void deleteCategory(int categoryEntityId);
    boolean categoryExists(String name, int parentId);
}
