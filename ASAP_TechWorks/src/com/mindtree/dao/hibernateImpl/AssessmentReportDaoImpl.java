/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mindtree.dao.IAssessmentReportDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentReport;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Candidate;
import com.mindtree.model.Problem;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;

/**
 * @author M1012679
 * 
 */
public class AssessmentReportDaoImpl extends
		GenericDaoHibernateImpl<AssessmentSchedule, Integer> implements
		IAssessmentReportDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.dao.IAssessmentReportDao#getAllAssessmentReport()
	 */
	@Override
	public List<AssessmentReport> getAllAssessmentReport() throws DaoException {
List<AssessmentReport> assessmentReports = new ArrayList<AssessmentReport>();
		
		try {
			List list = new ArrayList();
			list = getHibernateTemplate().find("reports");
			if (list.isEmpty()) {
				throw new DaoException("No Results Found !!");
			} else {
				for (int i = 0; i < list.size(); i++) {
					Object[] object = (Object[]) list.get(i);
					Candidate candidate = new Candidate();
					Problem problem = new Problem();
					Score score = new Score();
					Solution solution = new Solution();

					candidate.setName(object[0].toString());
					solution.setSubmittedOn((Date) object[1]);
					problem.setName(object[2].toString());
					score.setTotalScore((Double) object[3]);

					AssessmentReport assessmentReport = new AssessmentReport();
					assessmentReport.setCandidate(candidate);
					assessmentReport.setProblem(problem);
					assessmentReport.setScore(score);
					assessmentReport.setSolution(solution);

					System.out.println("Assessement report " + assessmentReport);
					
					assessmentReports.add(assessmentReport);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return assessmentReports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.dao.IAssessmentReportDao#getAssessmentReport(com.mindtree
	 * .model.AssessmentSchedule)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentReport> getAssessmentReport(
			AssessmentSchedule assessmentSchedule) throws DaoException {
		List<AssessmentReport> assessmentReports = new ArrayList<AssessmentReport>();
		
		try {
			List list = new ArrayList();
			list = getHibernateTemplate().findByNamedQueryAndNamedParam(
					"report",
					new String[] { "problemId" },
					new Object[] { assessmentSchedule.getProblem()
							.getProblemId() });
			if (list.isEmpty()) {
				throw new DaoException("No Results Found !!");
			} else {
				for (int i = 0; i < list.size(); i++) {
					Object[] object = (Object[]) list.get(i);
					Candidate candidate = new Candidate();
					Problem problem = new Problem();
					Score score = new Score();
					Solution solution = new Solution();

					candidate.setName(object[0].toString());
					solution.setSubmittedOn((Date) object[1]);
					problem.setName(object[2].toString());
					score.setTotalScore((Double) object[3]);

					AssessmentReport assessmentReport = new AssessmentReport();
					assessmentReport.setCandidate(candidate);
					assessmentReport.setProblem(problem);
					assessmentReport.setScore(score);
					assessmentReport.setSolution(solution);

					System.out.println("Assessement report " + assessmentReport);
					
					assessmentReports.add(assessmentReport);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
		return assessmentReports;
	}
}
