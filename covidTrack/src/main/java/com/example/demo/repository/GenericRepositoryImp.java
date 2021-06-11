package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepositoryImp implements GenericRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional //must for entitymanager
	public <T> T specialSave(Object object) {
		
		return (T) entityManager.merge(object);
	}

	@Override
	@Transactional
	public <T> T specialFetchById(Class<T> className, int id) {
		
		return entityManager.find(className, id);
	}

}
