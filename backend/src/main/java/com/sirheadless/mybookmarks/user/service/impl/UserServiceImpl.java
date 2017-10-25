package com.sirheadless.mybookmarks.user.service.impl;

import com.sirheadless.mybookmarks.user.entity.User;
import com.sirheadless.mybookmarks.user.repository.UserRepository;
import com.sirheadless.mybookmarks.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(int userEntityId) {
        System.out.println("UserServiceImpl get User for Id: " + userEntityId);
        User obj = userRepository.findByUserId(userEntityId);
        return obj;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;

    }


//	@Override
//	public void updateUser(User userEntity) {
//		userRepository.updateUser(userEntity);
//
//	}

    @Override
    public void deleteUser(int userEntityId) {
        userRepository.deleteByUserId(userEntityId);

    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
