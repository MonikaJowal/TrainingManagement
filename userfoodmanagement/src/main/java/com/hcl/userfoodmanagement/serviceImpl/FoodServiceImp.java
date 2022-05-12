package com.hcl.userfoodmanagement.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.hcl.userfoodmanagement.beans.Food;
import com.hcl.userfoodmanagement.beans.User;
import com.hcl.userfoodmanagement.dao.JPAUtilDAO;
import com.hcl.userfoodmanagement.service.ServiceInterface;

public class FoodServiceImp implements ServiceInterface {
	EntityManager entityManager=JPAUtilDAO.entityManager();
	
	@Override
	public List<Object> getAllData() {
		return entityManager.createNamedQuery("Food.findAll").getResultList();
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
		Food food=entityManager.find(Food.class, id);
        entityManager.remove(food);
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
		return entityManager.find(Food.class, id);
	}

}
