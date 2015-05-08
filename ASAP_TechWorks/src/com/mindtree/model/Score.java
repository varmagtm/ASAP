/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;

/**
 * @author m1012679
 * 
 */
public class Score implements Comparable<Score>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private int scoreId;
	private Candidate candidate;
	private Problem problem;
	private double totalScore;

	/**
	 * 
	 */
	public Score() {
		super();
	}

	/**
	 * @param scoreId
	 * @param candidate
	 * @param problem
	 * @param totalScore
	 */
	public Score(int scoreId, Candidate candidate, Problem problem,
			double totalScore) {
		super();
		this.candidate = candidate;
		this.problem = problem;
		this.totalScore = totalScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [candidate=" + candidate + ", problem=" + problem
				+  ", totalScore=" + totalScore + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + 1;
		long temp;
		temp = Double.doubleToLongBits(totalScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		
		if (Double.doubleToLongBits(totalScore) != Double
				.doubleToLongBits(other.totalScore))
			return false;
		return true;
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
	 * @return the totalScore
	 */
	public double getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore
	 *            the totalScore to set
	 */
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Score o) {
		return candidate.getCandidateId() - o.candidate.getCandidateId();
	}

}
