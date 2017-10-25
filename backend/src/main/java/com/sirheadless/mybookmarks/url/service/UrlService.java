package com.sirheadless.mybookmarks.url.service;

import com.sirheadless.mybookmarks.url.entity.Url;

import java.util.List;

public interface UrlService {
    List<Url> getAllUrls();

    Url getUrlById(int urlId);

    List<Url> getAllUrlsByUserId(int userId);

    boolean addUrl(Url url);

    void deleteUrl(int urlId);
}