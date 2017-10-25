package com.sirheadless.mybookmarks.category.repository;

import com.sirheadless.mybookmarks.category.entity.Category;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryRepository extends Repository<Category, Long> {
    List<Category> findAll();

    Category findByCategoryId(int categoryId);

    List<Category> findAllByUserId(int userId);

    void save(Category category);

    void deleteByCategoryId(int categoryId);
}
