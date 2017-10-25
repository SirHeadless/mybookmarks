package com.sirheadless.mybookmarks.user.repository;

import com.sirheadless.mybookmarks.user.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {
    List<User> findAll();

    User findByUserId(int userId);

    void save(User user);

    User findByUsername(String username);

    //    void updateUser(User user);
    void deleteByUserId(int userId);
}
