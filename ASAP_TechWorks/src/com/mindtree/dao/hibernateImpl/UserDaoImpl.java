/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.IUserDao;
import com.mindtree.exception.DaoException;

import com.mindtree.model.User;

/**
 * @author m1012679
 * 
 */
public class UserDaoImpl extends GenericDaoHibernateImpl<User, Integer>
		implements IUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.dao.IUserDao#getUserById(java.lang.Integer)
	 */
	@Override
	public User getUserById(Integer id) throws DaoException {
		return getEntity(User.class, id);
	}

	@Override
	public void deleteUser(User user) throws DaoException {
		deleteEntity(user);
	}

	@Override
	public User addUser(User user) throws DaoException {
		insert(user);
		List<User> users = new ArrayList<User>();
		users = getAllByQuery("from User where username='" + user.getUsername()
				+ "'");

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
