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
public interface AuthenticationDao {
	public User login(User user) throws DaoException;
	public void logout() throws DaoException;
}
