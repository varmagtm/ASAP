/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.TestCase;

/**
 * @author m1012679
 *
 */
public interface ITestCaseDao {
	public void addTestCase(TestCase testCase) throws DaoException;
	public List<TestCase> getTestCasesForProblem(int problemId) throws DaoException;
}
