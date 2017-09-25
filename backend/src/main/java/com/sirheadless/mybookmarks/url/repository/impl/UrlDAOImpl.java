//package com.sirheadless.mybookmarks.url.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.sirheadless.mybookmarks.url.repository.UrlRepository;
//import com.sirheadless.mybookmarks.url.entity.Url;
//
//@Transactional
//@Repository
//public class UrlDAOImpl implements UrlRepository{
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public Url getUrlEntityById(int urlEntityId) {
//		// TODO Auto-generated method stub
//		System.out.println("UrlDAOImpl get Url for Id: " + urlEntityId);
//		return entityManager.find(Url.class, urlEntityId);
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Url> getAllUrls() {
//		String hql = "FROM Url as urlE";
//		return (List<Url>) entityManager.createQuery(hql).getResultList();
//	}
//
//	@Override
//	public void addUrl(Url urlEntity) {
//		// TODO Auto-generated method stub
//		entityManager.persist(urlEntity);
//	}
//
//	@Override
//	public void updateUrl(Url urlEntity) {
//		Url urlEn = getUrlEntityById(urlEntity.getUrlId());
//		urlEn.setName(urlEntity.getName());
//		urlEn.setUrl(urlEntity.getUrl());
//		urlEn.setUrlType(urlEntity.getUrlType());
//		urlEn.setRating(urlEntity.getRating());
//		urlEn.setDescription(urlEntity.getDescription());
//		entityManager.flush();
//	}
//
//	@Override
//	public void deleteUrl(int urlEntityId) {
//		entityManager.remove(getUrlEntityById(urlEntityId));
//
//	}
//
//	@Override
//	public boolean urlExists(String url) {
//		String hql = "FROM Url as urlE WHERE urlE.url = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, url).getResultList().size();
//		return count > 0 ? true : false;
//	}
//
//}
