/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;

/**
 * @author M1012679
 * 
 */
public class AssessmentReport implements Serializable,
		Comparable<AssessmentReport> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Candidate candidate = new Candidate();
	private Problem problem = new Problem();
	private Score score = new Score();
	private Solution solution = new Solution();

	/**
	 * 
	 */
	public AssessmentReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param candidate
	 * @param problem
	 * @param score
	 * @param solution
	 */
	public AssessmentReport(Candidate candidate, Problem problem, Score score,
			Solution solution) {
		super();
		this.candidate = candidate;
		this.problem = problem;
		this.score = score;
		this.solution = solution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssessmentReport [candidate=" + candidate + ", problem="
				+ problem + ", score=" + score + ", solution=" + solution + "]";
	}

	/**
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate
	 *            the candidate to set
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the problem
	 */
	public Problem getProblem() {
		return problem;
	}

	/**
	 * @param problem
	 *            the problem to set
	 */
	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	/**
	 * @return the score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * @return the solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * @param solution
	 *            the solution to set
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	@Override
	public int compareTo(AssessmentReport assessmentReport) {
		return assessmentReport.getCandidate().getCandidateId()
				- this.getCandidate().getCandidateId();
	}
}
