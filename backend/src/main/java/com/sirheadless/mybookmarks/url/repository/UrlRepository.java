package com.sirheadless.mybookmarks.url.repository;

import com.sirheadless.mybookmarks.url.entity.Url;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UrlRepository extends Repository<Url, Long> {
    List<Url> findAll();

    Url findByUrlId(int urlId);

    //	@Query("select u from urls u where u.user_id = ?")
    List<Url> findAllByUserId(int userId);

    void save(Url url);

    void deleteByUrlId(int urlId);
}
