package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.Group;

public interface IGroupDao {
	/**
	 * This method adds the group
	 * @param group group to be added
	 * @throws DaoException
	 */
	public void addGroup(Group group) throws DaoException;
	/**
	 * This method lists all the groups
	 * @return List of groups
	 * @throws DaoException
	 */
	public List<Group> getAllGroups() throws DaoException;
	/**
	 * This method gets the group details by its id
	 * @param id unique id of the group
	 * @return
	 * @throws DaoException
	 */
	public Group getGroupById(Integer id) throws DaoException;
}
