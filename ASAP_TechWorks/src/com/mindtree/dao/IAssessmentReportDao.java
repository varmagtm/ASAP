/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentReport;
import com.mindtree.model.AssessmentSchedule;

/**
 * @author M1012679
 *
 */
public interface IAssessmentReportDao {
	public List<AssessmentReport> getAssessmentReport(AssessmentSchedule assessmentSchedule) throws DaoException;
	public List<AssessmentReport> getAllAssessmentReport() throws DaoException;
}
