package com.mindtree.dao;

import com.mindtree.exception.DaoException;
import com.mindtree.model.Score;

public interface IScoreDao {
	public void submitScore(Score score) throws DaoException;
}
