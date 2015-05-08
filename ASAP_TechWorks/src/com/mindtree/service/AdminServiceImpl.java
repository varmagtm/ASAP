/**
 * 
 */
package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dao.CandidateDao;
import com.mindtree.dao.IAssessmentReportDao;
import com.mindtree.dao.IGroupDao;
import com.mindtree.dao.IProblemDao;
import com.mindtree.dao.IScheduleAssessmentDao;
import com.mindtree.dao.ITestCaseDao;
import com.mindtree.dao.IUserDao;
import com.mindtree.exception.DaoException;
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
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IProblemDao problemDao;

	@Autowired
	IGroupDao groupDao;

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	IScheduleAssessmentDao scheduleAssessmentDao;

	@Autowired
	IUserDao userDao;

	@Autowired
	ITestCaseDao testCaseDao;

	@Autowired
	IAssessmentReportDao assessmentReportDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.service.IAdminService#getAllGroups()
	 */
	@Override
	public List<Group> getAllGroups() throws ServiceException {
		try {
			return groupDao.getAllGroups();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.service.IAdminService#getAllProblems()
	 */
	@Override
	public List<Problem> getAllProblems() throws ServiceException {
		try {
			return problemDao.getAllProblems();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.service.IAdminService#scheduleAssessment(com.mindtree.model
	 * .AssessmentSchedule)
	 */
	@Override
	public void scheduleAssessment(AssessmentSchedule assessmentSchedule)
			throws ServiceException {
		try {
			scheduleAssessmentDao.scheduleAnAssessment(assessmentSchedule);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void addCandidate(Candidate candidate) throws ServiceException {
		try {
			candidateDao.addCandidate(candidate);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Candidate> getAllCandidates() throws ServiceException {

		try {
			return candidateDao.getAllCandidates();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to get all candidates", e);
		}
	}

	@Override
	public Candidate getCandidateById(Integer id) throws ServiceException {
		try {
			return candidateDao.getCandidateById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to get the Candidate");
		}
	}

	@Override
	public void addGroup(Group group) throws ServiceException {
		try {
			groupDao.addGroup(group);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Group getGroupById(Integer id) throws ServiceException {
		try {
			return groupDao.getGroupById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to get the group");
		}
	}

	@Override
	public User getUserById(Integer id) throws ServiceException {
		try {
			return userDao.getUserById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to get user");
		}
	}

	@Override
	public void addProblem(Problem problem) throws ServiceException {
		try {
			problemDao.addProblem(problem);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void addTestCase(TestCase testCase) throws ServiceException {
		try {
			testCaseDao.addTestCase(testCase);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Problem getProblem(Candidate candidate) throws ServiceException {
		try {
			return problemDao.getProblem(candidate);
		} catch (DaoException e) {
			// e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void uploadFile(String fileLocation) throws ServiceException {
		try {
			problemDao.uploadFile(fileLocation);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Problem> getProblems(int groupId) throws ServiceException {
		try {
			return problemDao.getProblems(groupId);

		} catch (DaoException exception) {
			exception.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public void updateAssessment(AssessmentSchedule assessmentSchedule)
			throws ServiceException {
		try {
			scheduleAssessmentDao.updateAssessment(assessmentSchedule);
		} catch (DaoException exception) {
			exception.printStackTrace();
			throw new ServiceException(exception.getMessage());
		}
	}

	@Override
	public void associateCandidateWithGroup(Candidate candidate)
			throws ServiceException {
		try {
			candidateDao.associateCandidateWithGroup(candidate);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public User addUser(User user) throws ServiceException {
		try {
			return userDao.addUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<AssessmentReport> getAllAssessmentReport()
			throws ServiceException {
		try {
			return assessmentReportDao.getAllAssessmentReport();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<AssessmentReport> getAssessmentReport(
			AssessmentSchedule assessmentSchedule) throws ServiceException {
		try {
			return assessmentReportDao.getAssessmentReport(assessmentSchedule);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public int getScheduleId(AssessmentSchedule assessmentSchedule)
			throws ServiceException {
		try {
			return scheduleAssessmentDao.getScheduleId(assessmentSchedule);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Problem getProblemById(int problemId) throws ServiceException {
		try {
			return problemDao.getProblemById(problemId);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Candidate getCandidateByUserId(Integer id) throws ServiceException {
		try {
			return candidateDao.getCandidateByUserId(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to get the Candidate");
		}
	}
}
