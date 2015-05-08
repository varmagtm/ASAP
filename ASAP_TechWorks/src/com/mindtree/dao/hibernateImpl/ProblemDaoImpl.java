/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mindtree.dao.IProblemDao;
import com.mindtree.exception.DaoException;
import com.mindtree.model.Candidate;
import com.mindtree.model.Problem;

/**
 * @author m1012679
 * 
 */
public class ProblemDaoImpl extends GenericDaoHibernateImpl<Problem, Integer>
		implements IProblemDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.dao.IProblemDao#getAllProblems()
	 */
	@Override
	public List<Problem> getAllProblems() throws DaoException {
		try {
			return getAll(Problem.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("Unable to get problems");
		}
	}

	@Override
	public void addProblem(Problem problem) throws DaoException {
		// java.sql.Clob clob = Hibernate.createClob(problem.getDescription());
		// problem.setDescription(clob);
		insert(problem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Problem getProblem(Candidate candidate) throws DaoException {
		List<String> problems = null;
		try {
			// problems = hibernateTemplate.findByNamedQueryAndNamedParam(
			// "getProblemSQL", "candidateId", candidate.getCandidateId());
			problems = getHibernateTemplate().findByNamedQueryAndNamedParam(
					"getProblemSQL", new String[] { "candidateId", "time1" },
					new Object[] { candidate.getCandidateId(), new Date() });

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		Problem problem = new Problem();

		if (problems.isEmpty()) {
			throw new DaoException(
					"No Assessment scheduled for you currently!!!");
		} else {
			// Clob clob = Hibernate.createClob(problems.get(0));
			problem.setDescription(problems.get(0));
		}

		return problem;
	}

	@Override
	public void uploadFile(String fileLocation) throws DaoException {
		File file = new File(fileLocation);
		String name = file.getName();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			File target = new File(file,
					"http:\\localhost:8080\\Final\\Files\\" + name);
			BufferedWriter writer = new BufferedWriter(new FileWriter(target));
			String line = "";
			while ((line = reader.readLine()) != null) {
				writer.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Problem> getProblems(int groupId) throws DaoException {
		List<Problem> problemList = new ArrayList<Problem>();
		try {
			problemList = getHibernateTemplate().findByNamedQueryAndNamedParam(
					"getProblem", "id", groupId);

		} catch (DataAccessException exception) {
			exception.printStackTrace();
			throw new DaoException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		return problemList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Problem getProblemById(int problemId) throws DaoException {
		Problem problem = new Problem();
		List list = new ArrayList();
		list= getHibernateTemplate().find("from Problem where problemId="+problemId);
		if(!list.isEmpty()) {
			problem=(Problem)list.get(0);
		}
		return problem;
	}
}
