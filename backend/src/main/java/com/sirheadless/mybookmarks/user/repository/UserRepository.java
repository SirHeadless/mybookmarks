package com.sirheadless.mybookmarks.user.repository;

import java.util.List;

import com.sirheadless.mybookmarks.user.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Long>{
	List<User> findAll();
	User findByUserId(int userId);
    void save(User user);
    User findByUsername(String username);
//    void updateUser(User user);
    void deleteByUserId(int userId);
}
