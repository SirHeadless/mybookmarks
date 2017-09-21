package com.sirheadless.mybookmarks.user.dao;

import java.util.List;

import com.sirheadless.mybookmarks.user.entity.UserEntity;

public interface UserDAO {
	List<UserEntity> getAllUsers();
	UserEntity getUserEntityById(int userEntityId);
    void addUser(UserEntity userEntity);
//    void updateUser(UserEntity userEntity);
    void deleteUser(int userEntityId);
    boolean userExists(String user);
}
