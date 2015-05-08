package com.mindtree.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CompilerResult implements Serializable {

	private Solution solution;
	private Score score;
	private List<TestCase> testCases;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
	 * @return the testCases
	 */
	public List<TestCase> getTestCases() {
		return testCases;
	}

	/**
	 * @param testCases
	 *            the testCases to set
	 */
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

}
