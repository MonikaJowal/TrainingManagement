package com.hcl.userfoodmanagement.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.hcl.userfoodmanagement.beans.User;
import com.hcl.userfoodmanagement.dao.JPAUtilDAO;
import com.hcl.userfoodmanagement.service.ServiceInterface;

public class UserServiceImpl implements ServiceInterface {
	EntityManager entityManager=JPAUtilDAO.entityManager();
	@Override
	public List<Object> getAllData() {
		return entityManager.createNamedQuery("User.findAll").getResultList();
	
	}

	@Override
	public void updateObject(Object object) {
		entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
	}

	@Override
	public void deleteObject(Long id) {
		entityManager.getTransaction().begin();
		User user=entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
	}

	@Override
	public void saveData(Object object) {
		entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
                      
	}
	@Override
	public Object findById(Long id) {
		return entityManager.find(User.class, id);
	}

}
