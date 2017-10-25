package com.sirheadless.mybookmarks.user.controller;

import com.sirheadless.mybookmarks.user.entity.User;
import com.sirheadless.mybookmarks.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        System.out.println("UserController get User for Id: " + id);
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
//	@PostMapping("add")
//	public ResponseEntity<Void> addArticle(@RequestBody User userEntity, UriComponentsBuilder builder) {
//        boolean flag = userService.addUser(userEntity);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(userEntity.getUserId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}

//	@PutMapping("update")
//	public ResponseEntity<User> updateArticle(@RequestBody User userEntity) {
//		userService.updateUser(userEntity);
//		return new ResponseEntity<User>(userEntity, HttpStatus.OK);
//	}
//	@DeleteMapping("delete/{id}")
//	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
//		userService.deleteUser(id);
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}

}
