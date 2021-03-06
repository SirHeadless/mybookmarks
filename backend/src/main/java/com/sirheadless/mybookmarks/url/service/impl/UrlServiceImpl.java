package com.sirheadless.mybookmarks.url.service.impl;

import java.util.List;

import com.sirheadless.mybookmarks.url.repository.UrlRepository;
import com.sirheadless.mybookmarks.url.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirheadless.mybookmarks.url.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	@Autowired
	private UrlRepository urlRepository;

	@Override
	public Url getUrlById(int urlId) {
		System.out.println("UrlServiceImpl get Url for Id: " + urlId);
		Url obj = urlRepository.findByUrlId(urlId);
		return obj;
	}

	@Override
	public List<Url> getAllUrls() {
		return urlRepository.findAll();
	}

	@Override
	public boolean addUrl(Url url) {
		urlRepository.save(url);
		return true;
	}

	@Override
	public void deleteUrl(int urlId) {
		urlRepository.deleteByUrlId(urlId);

	}

}
