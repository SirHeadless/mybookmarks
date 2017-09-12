package com.sirheadless.mybookmarks.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirheadless.mybookmarks.category.dao.CategoryDAO;
import com.sirheadless.mybookmarks.category.entity.CategoryEntity;
import com.sirheadless.mybookmarks.category.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public CategoryEntity getCategoryById(int categoryEntityId) {
		System.out.println("CategoryServiceImpl get Category for Id: " + categoryEntityId);
		CategoryEntity obj = categoryDAO.getCategoryEntityById(categoryEntityId);
		return obj;
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		return categoryDAO.getAllCategories();
	}

	@Override
	public boolean addCategory(CategoryEntity categoryEntity) {
		System.out.println("ServiceAdd Category: " + categoryEntity);
		if (categoryDAO.categoryExists(categoryEntity.getName(), categoryEntity.getParentId())) {
			return false;
		} else {
			categoryDAO.addCategory(categoryEntity);
			return true;
		}
	}

	@Override
	public void updateCategory(CategoryEntity categoryEntity) {
		categoryDAO.updateCategory(categoryEntity);

	}

	@Override
	public void deleteCategory(int categoryEntityId) {
		categoryDAO.deleteCategory(categoryEntityId);

	}

}
