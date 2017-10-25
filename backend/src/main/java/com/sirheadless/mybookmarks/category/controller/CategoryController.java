package com.sirheadless.mybookmarks.category.controller;

import com.sirheadless.mybookmarks.authenticationfacade.AuthenticationFacade;
import com.sirheadless.mybookmarks.category.entity.Category;
import com.sirheadless.mybookmarks.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private CategoryService categoryService;

//	@GetMapping("/{id}")
//	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
//		System.out.println("CategoryController get Category for Id: " + id);
//		Category category = categoryService.getCategoryById(id);
//		return new ResponseEntity<Category>(category, HttpStatus.OK);
//	}

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Category>> getAllCategoriesByUserId(@PathVariable("userId") Integer userId) {
        System.out.println("CategoryController get all Categories for userId: " + userId);
        List<Category> list = categoryService.getAllCategoriesByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> list = categoryService.getAllCategoriesByUserId(authenticationFacade.getUserId());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addCategory(@RequestBody Category category) {
        System.out.println("Add Category " + category);
        Integer userId = authenticationFacade.getUserId();
        if (userId != null) {
            category.setUserId(userId);
            boolean flag = categoryService.addCategory(category);
            if (!flag) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(builder.path("/article/{id}").buildAndExpand(category.getCategoryId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {

        ResponseEntity<Void> noAuthentication = checkAuthentication(id);
        if (noAuthentication != null) {
            return noAuthentication;
        }

        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<Void> checkAuthentication(int id) {
        Integer userId = authenticationFacade.getUserId();
        if (userId != null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (category.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

}
