/**
 * 
 */
package com.mindtree.dao;



import com.mindtree.exception.DaoException;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;


/**
 * @author m1012679
 *
 */
public interface ISolutionDao {
	public void submitSolution(Solution solution) throws DaoException;
	
	
}
