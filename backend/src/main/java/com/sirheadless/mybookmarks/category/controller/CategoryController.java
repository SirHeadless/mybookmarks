package com.sirheadless.mybookmarks.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sirheadless.mybookmarks.category.entity.CategoryEntity;
import com.sirheadless.mybookmarks.category.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable("id") Integer id) {
		System.out.println("CategoryController get Category for Id: " + id);
		CategoryEntity categoryEntity = categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryEntity>(categoryEntity, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryEntity>> getAllCategories() {
		List<CategoryEntity> list = categoryService.getAllCategories();
		return new ResponseEntity<List<CategoryEntity>>(list, HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<Void> addCategory(@RequestBody CategoryEntity categoryEntity, UriComponentsBuilder builder) {
		System.out.println("Add Category " + categoryEntity);
        boolean flag = categoryService.addCategory(categoryEntity);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(categoryEntity.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("update")
	public ResponseEntity<CategoryEntity> updateArticle(@RequestBody CategoryEntity categoryEntity) {
		categoryService.updateCategory(categoryEntity);
		return new ResponseEntity<CategoryEntity>(categoryEntity, HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
