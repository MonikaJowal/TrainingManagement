package com.hcl.userfoodmanagement.service;

import java.util.List;

public interface ServiceInterface {
	public List<Object>getAllData();
	public void updateObject(Object object);
	public void deleteObject(Long id);
	public void saveData(Object object);
	public Object findById(Long id);
	

}
