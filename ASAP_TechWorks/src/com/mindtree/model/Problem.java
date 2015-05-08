/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;

/**
 * @author m1012679
 * 
 */
public class Problem implements Serializable, Comparable<Problem> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int problemId;
	private String name;
	private String description;
	private String input;
	private String output;
	private int timeLimit;

	/**
	 * @param problemId
	 * @param name
	 * @param description
	 * @param input
	 * @param output
	 * @param timeLimit
	 */
	public Problem(int problemId, String name, String description,
			String input, String output, int timeLimit) {
		super();
		this.problemId = problemId;
		this.name = name;
		this.description = description;
		this.input = input;
		this.output = output;
		this.timeLimit = timeLimit;
	}

	/**
	 * 
	 */
	public Problem() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Problem [description=" + description + ", input=" + input
				+ ", name=" + name + ", output=" + output + ", problemId="
				+ problemId + ", timeLimit=" + timeLimit + "]";
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result + problemId;
		long temp;
		temp = Double.doubleToLongBits(timeLimit);
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
		Problem other = (Problem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (input == null) {
			if (other.input != null)
				return false;
		} else if (!input.equals(other.input))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		if (problemId != other.problemId)
			return false;
		if (Double.doubleToLongBits(timeLimit) != Double
				.doubleToLongBits(other.timeLimit))
			return false;
		return true;
	}

	/**
	 * @return the problemId
	 */
	public int getProblemId() {
		return problemId;
	}

	/**
	 * @param problemId
	 *            the problemId to set
	 */
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * @return the timeLimit
	 */
	public int getTimeLimit() {
		return timeLimit;
	}

	/**
	 * @param timeLimit
	 *            the timeLimit to set
	 */
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Override
	public int compareTo(Problem o) {
		return problemId - o.problemId;
	}
}
