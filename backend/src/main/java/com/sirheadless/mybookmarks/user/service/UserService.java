package com.sirheadless.mybookmarks.user.service;

import java.util.List;

import com.sirheadless.mybookmarks.user.entity.UserEntity;

public interface UserService {
    List<UserEntity> getAllUsers();
	UserEntity getUserById(int userEntityId);
    boolean addUser(UserEntity userEntity);
//    void updateUser(UserEntity userEntity);
    void deleteUser(int userEntityId);
}
