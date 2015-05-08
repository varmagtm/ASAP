package com.mindtree.dao;

import java.util.List;

import com.mindtree.exception.DaoException;
import com.mindtree.model.Candidate;

/**
 * @author m1012776
 * 
 */
public interface CandidateDao {
	/**
	 * This method persists a candidate
	 * 
	 * @param candidate
	 * @throws DaoException
	 */
	public void addCandidate(Candidate candidate) throws DaoException;

	/**
	 * This method lists all the candidates
	 * 
	 * @return list of candidates
	 * @throws DaoException
	 */
	public List<Candidate> getAllCandidates() throws DaoException;

	/**
	 * This method gets the candidate details by his id
	 * 
	 * @param id
	 *            id of candidate
	 * @return Candidate
	 * @throws DaoException
	 */
	public Candidate getCandidateById(Integer id) throws DaoException;

	public void associateCandidateWithGroup(Candidate candidate)
			throws DaoException;
	
	public Candidate getCandidateByUserId(Integer id) throws DaoException;
}
