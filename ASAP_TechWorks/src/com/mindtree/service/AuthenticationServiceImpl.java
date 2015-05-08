/**
 * 
 */
package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dao.AuthenticationDao;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.User;

/**
 * @author m1012679
 *
 */
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	AuthenticationDao authenticationDao;
	/* (non-Javadoc)
	 * @see com.mindtree.service.AuthenticationService#login(com.mindtree.model.User)
	 */
	@Override
	public User login(User user) throws ServiceException {
		try {
			return authenticationDao.login(user);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Invalid Username/Password");
		}
	}
}
