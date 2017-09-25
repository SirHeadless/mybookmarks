//package com.sirheadless.mybookmarks.category.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.sirheadless.mybookmarks.category.repository.CategoryRepository;
//import com.sirheadless.mybookmarks.category.entity.Category;
//
//@Transactional
//@Repository
//public class CategoryDAOImpl implements CategoryRepository{
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public Category getCategoryEntityById(int categoryEntityId) {
//		// TODO Auto-generated method stub
//		System.out.println("CategoryDAOImpl get Category for Id: " + categoryEntityId);
//		return entityManager.find(Category.class, categoryEntityId);
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Category> getAllCategories() {
//		String hql = "FROM Category as categoryE";
//		return (List<Category>) entityManager.createQuery(hql).getResultList();
//	}
//
//	@Override
//	public void addCategory(Category categoryEntity) {
//		// TODO Auto-generated method stub
//		System.out.println("DAOAdd Category: " + categoryEntity);
//		entityManager.persist(categoryEntity);
//	}
//
//	@Override
//	public void updateCategory(Category categoryEntity) {
//		Category categoryEn = getCategoryEntityById(categoryEntity.getCategoryId());
//		categoryEn.setName(categoryEntity.getName());
//		categoryEn.setParentId(categoryEntity.getParentId());
//		categoryEn.setDescription(categoryEntity.getDescription());
//		entityManager.flush();
//	}
//
//	@Override
//	public void deleteCategory(int categoryEntityId) {
//		entityManager.remove(getCategoryEntityById(categoryEntityId));
//
//	}
//
//	@Override
//	public boolean categoryExists(String name, int parentId) {
//		String hql = "FROM Category as categoryE WHERE categoryE.name = ? AND categoryE.parentId = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, parentId).getResultList().size();
//		return count > 0 ? true : false;
//	}
//
//}
