/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.List;

import com.mindtree.dao.AuthenticationDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.User;

/**
 * @author m1012679
 *
 */
public class AuthenticationDaoImpl extends
GenericDaoHibernateImpl<User, Integer> implements AuthenticationDao {

	/* (non-Javadoc)
	 * @see com.mindtree.dao.AuthenticationDao#login(com.mindtree.model.User)
	 */
	@Override
	public User login(User user) throws DaoException {
		try {
			List<User> users = getAllByQuery("from User where username='" + user.getUsername() + "' and password='" + user.getPassword()+"'");
			if(users.size() >= 1) {
				System.out.println("USER : " + users.get(0));
				return users.get(0);
			}
			throw new DaoException("Couldnt get user");
		} catch (Exception e) {
			throw new DaoException("Invalid Username/password");
		}
	}

	/* (non-Javadoc)
	 * @see com.mindtree.dao.AuthenticationDao#logout()
	 */
	@Override
	public void logout() throws DaoException {
		
	}
}
