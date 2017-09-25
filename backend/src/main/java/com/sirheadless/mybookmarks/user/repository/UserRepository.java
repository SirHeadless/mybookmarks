package com.sirheadless.mybookmarks.user.repository;

import java.util.List;

import com.sirheadless.mybookmarks.user.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Long>{
	List<User> findAll();
	User findByUserId(int userId);
    void save(User user);
//    void updateUser(User user);
    void deleteByUserId(int userId);
}
