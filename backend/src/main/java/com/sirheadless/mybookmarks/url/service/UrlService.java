package com.sirheadless.mybookmarks.url.service;

import java.util.List;

import com.sirheadless.mybookmarks.url.entity.Url;

public interface UrlService {
    List<Url> getAllUrls();
	Url getUrlById(int urlId);
    boolean addUrl(Url url);
    void deleteUrl(int urlId);
}