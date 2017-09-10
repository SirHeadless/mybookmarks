package com.sirheadless.mybookmarks.url.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sirheadless.mybookmarks.url.dao.UrlDAO;
import com.sirheadless.mybookmarks.url.entity.UrlEntity;

@Transactional
@Repository
public class UrlDAOImpl implements UrlDAO{
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public UrlEntity getUrlEntityById(int urlEntityId) {
		// TODO Auto-generated method stub
		System.out.println("UrlDAOImpl get Url for Id: " + urlEntityId);
		return entityManager.find(UrlEntity.class, urlEntityId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UrlEntity> getAllUrls() {
		String hql = "FROM UrlEntity as urlE";
		return (List<UrlEntity>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addUrl(UrlEntity urlEntity) {
		// TODO Auto-generated method stub
		entityManager.persist(urlEntity);
	}

	@Override
	public void updateUrl(UrlEntity urlEntity) {
		UrlEntity urlEn = getUrlEntityById(urlEntity.getUrlId());
		urlEn.setName(urlEntity.getName());
		urlEn.setUrl(urlEntity.getUrl());
		urlEn.setUrlType(urlEntity.getUrlType());
		urlEn.setRating(urlEntity.getRating());
		urlEn.setDescription(urlEntity.getDescription());
		entityManager.flush();
	}

	@Override
	public void deleteUrl(int urlEntityId) {
		entityManager.remove(getUrlEntityById(urlEntityId));
		
	}

	@Override
	public boolean urlExists(String url) {
		String hql = "FROM UrlEntity as urlE WHERE urlE.url = ?";
		int count = entityManager.createQuery(hql).setParameter(1, url).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
