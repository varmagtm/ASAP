package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.AssessmentSchedule;

public interface IAssessmentDao {
	public List<AssessmentSchedule > getAllAssignedAssessments(int userId) throws DaoException;

}
