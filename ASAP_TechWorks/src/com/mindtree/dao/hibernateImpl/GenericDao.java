package com.mindtree.dao.hibernateImpl;

import java.util.List;

import com.mindtree.exception.DaoException;
/*
 * Generic interface for all CRUD operations
 */
public interface GenericDao<T,ID> {
	public void insert(T entity) throws DaoException;
	public T getEntity(Class<?> theClass, ID id) throws DaoException;
	public List<T> getAll(Class<?> theClass) throws DaoException;
	public List<T> getAllByQuery(String query) throws DaoException;
	public void merge(T entity) throws DaoException;
	public List<T> getByExample(T entity) throws DaoException;
	public void deleteEntity(T entity) throws DaoException;
}
