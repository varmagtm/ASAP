/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mindtree.dao.IAssessmentDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentSchedule;
import com.mindtree.model.Problem;

/**
 * @author m1012776
 * 
 */
public class AssessmentDaoHibernateImpl extends
		GenericDaoHibernateImpl<AssessmentSchedule, Integer> implements
		IAssessmentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.dao.IAssessmentDao#getAllAssignedAssessments()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AssessmentSchedule> getAllAssignedAssessments(int userId)
			throws DaoException {
		List<AssessmentSchedule> assessmentSchedules = new ArrayList<AssessmentSchedule>();

		List list = new ArrayList();
		list = getHibernateTemplate().findByNamedQueryAndNamedParam(
				"viewAssessments", "userId", userId);

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				int problemId = Integer.parseInt(obj[0].toString());
				Date startDate = (Date) obj[1];
				Date endDate = (Date) obj[2];
				String problemName = obj[3].toString();

				Problem problem = new Problem();
				problem.setProblemId(problemId);
				problem.setName(problemName);
				AssessmentSchedule assessmentSchedule = new AssessmentSchedule();
				assessmentSchedule.setStartDate(startDate);
				assessmentSchedule.setEndDate(endDate);

				assessmentSchedule.setProblem(problem);

				assessmentSchedules.add(assessmentSchedule);
			}
		}
		return assessmentSchedules;
	}

}
