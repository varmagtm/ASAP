/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.List;

import com.mindtree.dao.IGroupDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.Group;

/**
 * @author m1012679
 * 
 */
public class GroupDaoImpl extends GenericDaoHibernateImpl<Group, Integer>
		implements IGroupDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.dao.IGroupDao#getAllGroups()
	 */
	@Override
	public List<Group> getAllGroups() throws DaoException {
		try {
			return getAll(Group.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Unable to get groups");
		}
	}

	@Override
	public void addGroup(Group group) throws DaoException {
		insert(group);
	}

	@Override
	public Group getGroupById(Integer id) throws DaoException {
		Group group = (Group) getEntity(Group.class, id);
		return group;
	}
}
