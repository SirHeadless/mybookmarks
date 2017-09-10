package com.sirheadless.mybookmarks.url.dao;

import java.util.List;

import com.sirheadless.mybookmarks.url.entity.UrlEntity;

public interface UrlDAO {
	List<UrlEntity> getAllUrls();
	UrlEntity getUrlEntityById(int urlEntityId);
    void addUrl(UrlEntity urlEntity);
    void updateUrl(UrlEntity urlEntity);
    void deleteUrl(int urlEntityId);
    boolean urlExists(String url);
}
