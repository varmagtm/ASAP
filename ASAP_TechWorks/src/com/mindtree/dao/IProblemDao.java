/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.Candidate;
import com.mindtree.model.Problem;

/**
 * @author m1012679
 * 
 */
public interface IProblemDao {
	public List<Problem> getAllProblems() throws DaoException;

	public void addProblem(Problem problem) throws DaoException;

	public Problem getProblem(Candidate candidate) throws DaoException;

	public void uploadFile(String fileLocation) throws DaoException;

	public List<Problem> getProblems(int groupId) throws DaoException;

	public Problem getProblemById(int problemId) throws DaoException;
}
