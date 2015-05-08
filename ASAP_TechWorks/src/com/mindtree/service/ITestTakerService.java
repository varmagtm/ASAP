package com.mindtree.service;

import java.util.List;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;
import com.mindtree.model.TestCase;

public interface ITestTakerService {
	public List<AssessmentSchedule> getAllAssignedAssessments(int userId)
			throws ServiceException;

	public void submitSolution(Solution solution) throws ServiceException;
	
	public List<TestCase> getTestCasesForProblem(int problemId) throws ServiceException;
	
	public void submitScore(Score score) throws ServiceException;

}
