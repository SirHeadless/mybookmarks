package com.sirheadless.mybookmarks.url.service;

import java.util.List;

import com.sirheadless.mybookmarks.url.entity.UrlEntity;

public interface UrlService {
    List<UrlEntity> getAllUrls();
	UrlEntity getUrlById(int urlEntityId);
    boolean addUrl(UrlEntity urlEntity);
    void updateUrl(UrlEntity urlEntity);
    void deleteUrl(int urlEntityId);
}
