/**
 * 
 */
package com.mindtree.service;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.User;

/**
 * @author m1012679
 *
 */
public interface AuthenticationService {
	public User login(User user) throws ServiceException;
}
