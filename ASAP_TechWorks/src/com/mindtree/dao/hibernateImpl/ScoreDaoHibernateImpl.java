package com.mindtree.dao.hibernateImpl;


import com.mindtree.dao.IScoreDao;
import com.mindtree.exception.ApplicationException;
import com.mindtree.exception.DaoException;
import com.mindtree.model.Score;

public class ScoreDaoHibernateImpl extends GenericDaoHibernateImpl<Score, Integer> implements IScoreDao{

	@Override
	public void submitScore(Score score) throws DaoException {
		try {
			insert(score);
		} catch (ApplicationException e) {
			throw new DaoException("Source code can be submitted only once against a problem statement");
		}
		
	}

	

}
