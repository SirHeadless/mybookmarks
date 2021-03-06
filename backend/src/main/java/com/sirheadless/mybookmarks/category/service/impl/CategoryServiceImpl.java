package com.sirheadless.mybookmarks.category.service.impl;

import java.util.List;

import com.sirheadless.mybookmarks.category.repository.CategoryRepository;
import com.sirheadless.mybookmarks.category.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirheadless.mybookmarks.category.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int categoryId) {
		System.out.println("CategoryServiceImpl get Category for Id: " + categoryId);
		Category obj = categoryRepository.findByCategoryId(categoryId);
		return obj;
	}

	@Override
	public boolean addCategory(Category category) {
		categoryRepository.save(category);
		return true;
	}


	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteByCategoryId(categoryId);

	}

}
