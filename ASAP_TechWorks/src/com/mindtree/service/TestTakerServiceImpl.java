package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dao.IAssessmentDao;
import com.mindtree.dao.IScoreDao;
import com.mindtree.dao.ISolutionDao;
import com.mindtree.dao.ITestCaseDao;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;
import com.mindtree.model.TestCase;

public class TestTakerServiceImpl implements ITestTakerService {

	@Autowired
	private IAssessmentDao assessmentDao;

	@Autowired
	private ISolutionDao solutionDao;
	
	@Autowired
	private ITestCaseDao testCaseDao;
	
	@Autowired
	private IScoreDao scoreDao;

	@Override
	public List<AssessmentSchedule> getAllAssignedAssessments(int userId)
			throws ServiceException {
		try {
			return assessmentDao.getAllAssignedAssessments(userId);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void submitSolution(Solution solution) throws ServiceException {
		try {
			solutionDao.submitSolution(solution);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<TestCase> getTestCasesForProblem(int problemId)
			throws ServiceException {
		try {
			return testCaseDao.getTestCasesForProblem(problemId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void submitScore(Score score) throws ServiceException {
		try {
			scoreDao.submitScore(score);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
