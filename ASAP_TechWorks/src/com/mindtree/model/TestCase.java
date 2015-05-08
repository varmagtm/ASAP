/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;

/**
 * @author m1012679
 * 
 */
public class TestCase implements Serializable, Comparable<TestCase> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int testCaseId;
	private Problem problem = new Problem();
	private String testCaseDescription;
	private String inputData;
	private String expectedOutput;
	private String actualOutput;
	private double score;
	private String status;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 */
	public TestCase() {
		super();
	}

	/**
	 * @param testCaseId
	 * @param problem
	 * @param testCaseDescription
	 * @param inputData
	 * @param expectedOutput
	 * @param weightage
	 */
	public TestCase(int testCaseId, Problem problem,
			String testCaseDescription, String inputData,
			String expectedOutput, double weightage) {
		super();
		this.testCaseId = testCaseId;
		this.problem = problem;
		this.testCaseDescription = testCaseDescription;
		this.inputData = inputData;
		this.expectedOutput = expectedOutput;
		this.score = weightage;
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
		result = prime * result
				+ ((expectedOutput == null) ? 0 : expectedOutput.hashCode());
		result = prime * result
				+ ((inputData == null) ? 0 : inputData.hashCode());
		result = prime
				* result
				+ ((testCaseDescription == null) ? 0 : testCaseDescription
						.hashCode());
		result = prime * result + testCaseId;
		long temp;
		temp = Double.doubleToLongBits(score);
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
		TestCase other = (TestCase) obj;
		if (expectedOutput == null) {
			if (other.expectedOutput != null)
				return false;
		} else if (!expectedOutput.equals(other.expectedOutput))
			return false;
		if (inputData == null) {
			if (other.inputData != null)
				return false;
		} else if (!inputData.equals(other.inputData))
			return false;
		if (testCaseDescription == null) {
			if (other.testCaseDescription != null)
				return false;
		} else if (!testCaseDescription.equals(other.testCaseDescription))
			return false;
		if (testCaseId != other.testCaseId)
			return false;
		if (Double.doubleToLongBits(score) != Double
				.doubleToLongBits(other.score))
			return false;
		return true;
	}

	/**
	 * @return the testCaseId
	 */
	public int getTestCaseId() {
		return testCaseId;
	}

	/**
	 * @param testCaseId
	 *            the testCaseId to set
	 */
	public void setTestCaseId(int testCaseId) {
		this.testCaseId = testCaseId;
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
	 * @return the testCaseDescription
	 */
	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	/**
	 * @param testCaseDescription
	 *            the testCaseDescription to set
	 */
	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}

	/**
	 * @return the inputData
	 */
	public String getInputData() {
		return inputData;
	}

	/**
	 * @param inputData
	 *            the inputData to set
	 */
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	/**
	 * @return the expectedOutput
	 */
	public String getExpectedOutput() {
		return expectedOutput;
	}

	/**
	 * @param expectedOutput
	 *            the expectedOutput to set
	 */
	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	/**
	 * @return the weightage
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param weightage
	 *            the weightage to set
	 */
	public void setScore(double weightage) {
		this.score = weightage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TestCase o) {
		return testCaseId - o.testCaseId;
	}

	public void setActualOutput(String actualOutput) {
		this.actualOutput = actualOutput;
	}

	public String getActualOutput() {
		return actualOutput;
	}

}
