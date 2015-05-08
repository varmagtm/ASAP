/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.AssessmentReport;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Candidate;
import com.mindtree.model.Group;
import com.mindtree.model.Problem;
import com.mindtree.model.TestCase;
import com.mindtree.model.User;

/**
 * @author m1012679
 * 
 */
public interface IAdminService {
	public List<Problem> getAllProblems() throws ServiceException;

	public List<Group> getAllGroups() throws ServiceException;

	public void scheduleAssessment(AssessmentSchedule assessmentSchedule)
			throws ServiceException;

	public void addCandidate(Candidate candidate) throws ServiceException;

	public List<Candidate> getAllCandidates() throws ServiceException;

	public Candidate getCandidateById(Integer id) throws ServiceException;

	public void addGroup(Group group) throws ServiceException;

	public Group getGroupById(Integer id) throws ServiceException;

	public User getUserById(Integer id) throws ServiceException;

	public void addProblem(Problem problem) throws ServiceException;

	public void addTestCase(TestCase testCase) throws ServiceException;

	public Problem getProblem(Candidate candidate) throws ServiceException;
	
	public Problem getProblemById(int problemId) throws ServiceException;

	public void uploadFile(String fileLocation) throws ServiceException;

	public void updateAssessment(AssessmentSchedule assessmentSchedule)
			throws ServiceException;

	public List<Problem> getProblems(int groupId) throws ServiceException;

	public void associateCandidateWithGroup(Candidate candidate)
			throws ServiceException;

	public User addUser(User user) throws ServiceException;

	public List<AssessmentReport> getAssessmentReport(
			AssessmentSchedule assessmentSchedule) throws ServiceException;

	public List<AssessmentReport> getAllAssessmentReport()
			throws ServiceException;
	
	public int getScheduleId(AssessmentSchedule assessmentSchedule) throws ServiceException;
	
	public Candidate getCandidateByUserId(Integer id) throws ServiceException;

}
