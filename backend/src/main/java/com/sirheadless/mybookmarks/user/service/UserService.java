package com.sirheadless.mybookmarks.user.service;

import java.util.List;

import com.sirheadless.mybookmarks.user.entity.User;

public interface UserService {
    List<User> getAllUsers();
	User getUserById(int userEntityId);
	User getUserByUsername(String username);
    boolean addUser(User user);
//    void updateUser(User userEntity);
    void deleteUser(int userEntityId);
}
