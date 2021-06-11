package com.example.demo.repository;

public interface GenericRepository {
	
	<T> T specialSave(Object object);
	<T> T specialFetchById(Class<T> className, int id);

}
