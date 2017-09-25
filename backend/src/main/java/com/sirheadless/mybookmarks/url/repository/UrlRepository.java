package com.sirheadless.mybookmarks.url.repository;

import java.util.List;

import com.sirheadless.mybookmarks.url.entity.Url;
import org.springframework.data.repository.Repository;

public interface UrlRepository extends Repository<Url, Long> {
	List<Url> findAll();
	Url findByUrlId(int urlId);
    void save(Url url);
    void deleteByUrlId(int urlId);
}
