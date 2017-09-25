//package com.sirheadless.mybookmarks.user.repository.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.sirheadless.mybookmarks.user.repository.UserRepository;
//import com.sirheadless.mybookmarks.user.entity.User;
//
//@Transactional
//@Repository
//public class UserDAOImpl implements UserRepository{
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public User getUserEntityById(int userEntityId) {
//		// TODO Auto-generated method stub
//		System.out.println("UserDAOImpl get User for Id: " + userEntityId);
//		return entityManager.find(User.class, userEntityId);
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<User> getAllUsers() {
//		String hql = "FROM User as userE";
//		return (List<User>) entityManager.createQuery(hql).getResultList();
//	}
//
//	@Override
//	public void addUser(User userEntity) {
//		// TODO Auto-generated method stub
//		userEntity.setEnabled(true);
//		entityManager.persist(userEntity);
//	}
//
////	@Override
////	public void updateUser(User userEntity) {
////		User userEn = getUserEntityById(userEntity.getUserId());
////		userEn.setName(userEntity.getName());
////		userEn.setUser(userEntity.getUser());
////		userEn.setUserType(userEntity.getUserType());
////		userEn.setRating(userEntity.getRating());
////		userEn.setDescription(userEntity.getDescription());
////		entityManager.flush();
////	}
//
//	@Override
//	public void deleteUser(int userEntityId) {
//		entityManager.remove(getUserEntityById(userEntityId));
//
//	}
//
//	@Override
//	public boolean userExists(String user) {
//		String hql = "FROM User as userE WHERE userE.user = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, user).getResultList().size();
//		return count > 0 ? true : false;
//	}
//
//}
