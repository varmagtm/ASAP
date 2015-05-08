/**
 * 
 */
package com.mindtree.dao;

import com.mindtree.exception.DaoException;
import com.mindtree.model.User;

/**
 * @author m1012679
 *
 */
public interface IUserDao {
	public User getUserById(Integer id) throws DaoException;
	public void deleteUser(User user) throws DaoException;
	public User addUser(User user) throws DaoException;
}
