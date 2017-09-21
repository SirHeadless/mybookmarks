package com.sirheadless.mybookmarks.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirheadless.mybookmarks.user.dao.UserDAO;
import com.sirheadless.mybookmarks.user.entity.UserEntity;
import com.sirheadless.mybookmarks.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserEntity getUserById(int userEntityId) {
		System.out.println("UserServiceImpl get User for Id: " + userEntityId);
		UserEntity obj = userDAO.getUserEntityById(userEntityId);
		return obj;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public boolean addUser(UserEntity userEntity) {
		if (userDAO.userExists(userEntity.getUsername())) {
			return false;
		} else {
			userDAO.addUser(userEntity);
			return true;
		}
	}

//	@Override
//	public void updateUser(UserEntity userEntity) {
//		userDAO.updateUser(userEntity);
//
//	}

	@Override
	public void deleteUser(int userEntityId) {
		userDAO.deleteUser(userEntityId);

	}

}
