/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.List;

import com.mindtree.dao.ITestCaseDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.TestCase;

/**
 * @author m1012679
 *
 */
public class TestCaseDaoImpl extends GenericDaoHibernateImpl<TestCase, Integer> implements ITestCaseDao {

	@Override
	public void addTestCase(TestCase testCase) throws DaoException {
		insert(testCase);
	}

	@Override
	public List<TestCase> getTestCasesForProblem(int problemId)
			throws DaoException {
		try {
			return hibernateTemplate.find("from TestCase where problem.problemId = "+problemId);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

}
