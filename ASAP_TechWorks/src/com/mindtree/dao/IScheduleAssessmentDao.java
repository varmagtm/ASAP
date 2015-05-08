/**
 * 
 */
package com.mindtree.dao;

import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentSchedule;

/**
 * @author m1012679
 *
 */
public interface IScheduleAssessmentDao {
	public void scheduleAnAssessment(AssessmentSchedule assessmentSchedule) throws DaoException;
	public void updateAssessment(AssessmentSchedule assessmentSchedule) throws DaoException;
	public int getScheduleId(AssessmentSchedule assessmentSchedule) throws DaoException;
}
