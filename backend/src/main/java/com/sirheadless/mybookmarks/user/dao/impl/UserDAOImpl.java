package com.sirheadless.mybookmarks.user.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sirheadless.mybookmarks.user.dao.UserDAO;
import com.sirheadless.mybookmarks.user.entity.UserEntity;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public UserEntity getUserEntityById(int userEntityId) {
		// TODO Auto-generated method stub
		System.out.println("UserDAOImpl get User for Id: " + userEntityId);
		return entityManager.find(UserEntity.class, userEntityId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() {
		String hql = "FROM UserEntity as userE";
		return (List<UserEntity>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntity.setEnabled(true);
		entityManager.persist(userEntity);
	}

//	@Override
//	public void updateUser(UserEntity userEntity) {
//		UserEntity userEn = getUserEntityById(userEntity.getUserId());
//		userEn.setName(userEntity.getName());
//		userEn.setUser(userEntity.getUser());
//		userEn.setUserType(userEntity.getUserType());
//		userEn.setRating(userEntity.getRating());
//		userEn.setDescription(userEntity.getDescription());
//		entityManager.flush();
//	}

	@Override
	public void deleteUser(int userEntityId) {
		entityManager.remove(getUserEntityById(userEntityId));
		
	}

	@Override
	public boolean userExists(String user) {
		String hql = "FROM UserEntity as userE WHERE userE.user = ?";
		int count = entityManager.createQuery(hql).setParameter(1, user).getResultList().size();
		return count > 0 ? true : false;
	}	
	
}
