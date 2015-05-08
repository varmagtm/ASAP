package com.mindtree.dao.hibernateImpl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.exception.DaoException;

/**
 * 
 * @author m1012679
 *
 * @param <T>
 * @param <ID>
 */
@SuppressWarnings("unchecked")
public class GenericDaoHibernateImpl<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	protected HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory factory) {
		hibernateTemplate = new HibernateTemplate(factory);
	}

	protected HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public List<T> getAll(Class theClass) throws DaoException {
		try {
			return hibernateTemplate.loadAll(theClass);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to fetch records", e);
		}
	}

	@Override
	public List<T> getAllByQuery(String query) throws DaoException {
		try {
			return hibernateTemplate.find(query);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to fetch records", e);
		}
	}

	@Override
	public T getEntity(Class theClass, ID id) throws DaoException {
		try {
			return (T) hibernateTemplate.get(theClass, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException("Unable to get entity", e);
		}
	}

	@Override
	public void insert(T entity) throws DaoException {
		try {
			hibernateTemplate.persist(entity);
			hibernateTemplate.flush();
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Duplicate Entry", e);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to insert entity", e);
		} 
	}

	@Override
	public void merge(T entity) throws DaoException {
		try {
			hibernateTemplate.merge(entity);
		} catch (StaleObjectStateException e) {
			throw new DaoException(
					"Data modifed by other user, working on stale object", e);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to insert entity", e);
		}
	}

	@Override
	public List<T> getByExample(T entity) throws DaoException {
		try {
			return hibernateTemplate.findByExample(entity);

		} catch (StaleObjectStateException e) {
			throw new DaoException(
					"Data modifed by other user, working on stale object", e);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to insert entity", e);
		}
	}

	@Override
	public void deleteEntity(T entity) throws DaoException {

		try {
			hibernateTemplate.delete(entity);
		} catch (StaleObjectStateException e) {
			throw new DaoException(
					"Data modifed by other user, working on stale object", e);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to insert entity", e);
		}
	}
}
