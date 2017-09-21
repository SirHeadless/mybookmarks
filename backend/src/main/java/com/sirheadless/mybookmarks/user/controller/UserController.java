package com.sirheadless.mybookmarks.user.controller;

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

import com.sirheadless.mybookmarks.user.entity.UserEntity;
import com.sirheadless.mybookmarks.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer id) {
		System.out.println("UserController get User for Id: " + id);
		UserEntity userEntity = userService.getUserById(id);
		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> list = userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);
	}
	@PostMapping("add")
	public ResponseEntity<Void> addArticle(@RequestBody UserEntity userEntity, UriComponentsBuilder builder) {
        boolean flag = userService.addUser(userEntity);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(userEntity.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
//	@PutMapping("update")
//	public ResponseEntity<UserEntity> updateArticle(@RequestBody UserEntity userEntity) {
//		userService.updateUser(userEntity);
//		return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
//	}
//	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
