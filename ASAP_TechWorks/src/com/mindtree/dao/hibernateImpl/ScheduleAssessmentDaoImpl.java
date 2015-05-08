/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import com.mindtree.dao.IScheduleAssessmentDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentSchedule;

/**
 * @author m1012679
 * 
 */
public class ScheduleAssessmentDaoImpl extends
		GenericDaoHibernateImpl<AssessmentSchedule, Integer> implements
		IScheduleAssessmentDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.dao.IScheduleAssessmentDao#scheduleAnAssessment(com.mindtree
	 * .model.AssessmentSchedule)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void scheduleAnAssessment(AssessmentSchedule assessmentSchedule)
			throws DaoException {
		try {
			int id = 0;
			Session session = getHibernateTemplate().getSessionFactory()
					.openSession();
			String SQL_QUERY = "select max(scheduleId)from AssessmentSchedule";
			Query query = session.createQuery(SQL_QUERY);
			List list = new ArrayList();
			list = query.list();
			if (list.get(0) != null) {
				id = (Integer) list.get(0);
			}
			assessmentSchedule.setScheduleId(id + 1);
			insert(assessmentSchedule);
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public void updateAssessment(AssessmentSchedule assessmentSchedule)
			throws DaoException {
		try {
			merge(assessmentSchedule);
		} catch (DataAccessException exception) {
			exception.printStackTrace();
			throw new DaoException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getScheduleId(AssessmentSchedule assessmentSchedule)
			throws DaoException {
		int id = 0;
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		String SQL_QUERY = "SELECT SCHEDULE_ID FROM ASSESSMENT_SCHEDULE WHERE GROUP_ID="
				+ assessmentSchedule.getGroup().getGroupId()
				+ " AND PROBLEM_ID="
				+ assessmentSchedule.getProblem().getProblemId();
		Query query = session.createSQLQuery(SQL_QUERY);
		List list = new ArrayList();
		list = query.list();
		if (list.get(0) != null) {
			id = (Integer) list.get(0);
		}
		return id;
	}
}
