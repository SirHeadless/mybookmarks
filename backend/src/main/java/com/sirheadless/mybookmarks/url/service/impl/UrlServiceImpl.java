package com.sirheadless.mybookmarks.url.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirheadless.mybookmarks.url.dao.UrlDAO;
import com.sirheadless.mybookmarks.url.entity.UrlEntity;
import com.sirheadless.mybookmarks.url.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	@Autowired
	private UrlDAO urlDAO;

	@Override
	public UrlEntity getUrlById(int urlEntityId) {
		System.out.println("UrlServiceImpl get Url for Id: " + urlEntityId);
		UrlEntity obj = urlDAO.getUrlEntityById(urlEntityId);
		return obj;
	}

	@Override
	public List<UrlEntity> getAllUrls() {
		return urlDAO.getAllUrls();
	}

	@Override
	public boolean addUrl(UrlEntity urlEntity) {
		if (urlDAO.urlExists(urlEntity.getUrl())) {
			return false;
		} else {
			urlDAO.addUrl(urlEntity);
			return true;
		}
	}

	@Override
	public void updateUrl(UrlEntity urlEntity) {
		urlDAO.updateUrl(urlEntity);

	}

	@Override
	public void deleteUrl(int urlEntityId) {
		urlDAO.deleteUrl(urlEntityId);

	}

}
