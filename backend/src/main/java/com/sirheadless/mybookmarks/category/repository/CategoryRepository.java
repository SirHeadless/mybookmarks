package com.sirheadless.mybookmarks.category.repository;

import java.util.List;

import com.sirheadless.mybookmarks.category.entity.Category;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category,Long>{
	List<Category> findAll();
	Category findByCategoryId(int categoryId);
	List<Category> findAllByUserId(int userId);
    void save(Category category);
    void deleteByCategoryId(int categoryId);
}
