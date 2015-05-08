/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author m1012679
 * 
 */
public class Solution implements Comparable<Solution>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private int solutionId;
	private Candidate candidate;
	private Problem problem;
	private int submitNumber;
	private Date submittedOn;
	private String filename;
	private String sourceCode;
	private String compiler;
	private String complierState;
	private String compilerError;

	/**
	 * 
	 */
	public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param solutionId
	 * @param candidate
	 * @param problem
	 * @param submitNumber
	 * @param submittedOn
	 * @param filename
	 * @param sourceCode
	 * @param compiler
	 * @param complierState
	 * @param compilerError
	 */
	public Solution(int solutionId, Candidate candidate, Problem problem,
			int submitNumber, Date submittedOn, String filename,
			String sourceCode, String compiler, String complierState,
			String compilerError) {
		super();
		this.candidate = candidate;
		this.problem = problem;
		this.submitNumber = submitNumber;
		this.submittedOn = submittedOn;
		this.filename = filename;
		this.sourceCode = sourceCode;
		this.compiler = compiler;
		this.complierState = complierState;
		this.compilerError = compilerError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Solution [candidate=" + candidate + ", compiler=" + compiler
				+ ", compilerError=" + compilerError + ", complierState="
				+ complierState + ", filename=" + filename + ", problem="
				+ problem +  ", sourceCode="
				+ sourceCode + ", submitNumber=" + submitNumber
				+ ", submittedOn=" + submittedOn + "]";
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((compiler == null) ? 0 : compiler.hashCode());
		result = prime * result
				+ ((compilerError == null) ? 0 : compilerError.hashCode());
		result = prime * result
				+ ((complierState == null) ? 0 : complierState.hashCode());
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result
				+ ((sourceCode == null) ? 0 : sourceCode.hashCode());
		result = prime * result + submitNumber;
		result = prime * result
				+ ((submittedOn == null) ? 0 : submittedOn.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Solution other = (Solution) obj;
		if (compiler == null) {
			if (other.compiler != null)
				return false;
		} else if (!compiler.equals(other.compiler))
			return false;
		if (compilerError == null) {
			if (other.compilerError != null)
				return false;
		} else if (!compilerError.equals(other.compilerError))
			return false;
		if (complierState == null) {
			if (other.complierState != null)
				return false;
		} else if (!complierState.equals(other.complierState))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (sourceCode == null) {
			if (other.sourceCode != null)
				return false;
		} else if (!sourceCode.equals(other.sourceCode))
			return false;
		if (submitNumber != other.submitNumber)
			return false;
		if (submittedOn == null) {
			if (other.submittedOn != null)
				return false;
		} else if (!submittedOn.equals(other.submittedOn))
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
	 * @return the submitNumber
	 */
	public int getSubmitNumber() {
		return submitNumber;
	}

	/**
	 * @param submitNumber
	 *            the submitNumber to set
	 */
	public void setSubmitNumber(int submitNumber) {
		this.submitNumber = submitNumber;
	}

	/**
	 * @return the submittedOn
	 */
	public Date getSubmittedOn() {
		return submittedOn;
	}

	/**
	 * @param submittedOn
	 *            the submittedOn to set
	 */
	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * @param sourceCode
	 *            the sourceCode to set
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	/**
	 * @return the compiler
	 */
	public String getCompiler() {
		return compiler;
	}

	/**
	 * @param compiler
	 *            the compiler to set
	 */
	public void setCompiler(String compiler) {
		this.compiler = compiler;
	}

	/**
	 * @return the complierState
	 */
	public String getComplierState() {
		return complierState;
	}

	/**
	 * @param complierState
	 *            the complierState to set
	 */
	public void setComplierState(String complierState) {
		this.complierState = complierState;
	}

	/**
	 * @return the compilerError
	 */
	public String getCompilerError() {
		return compilerError;
	}

	/**
	 * @param compilerError
	 *            the compilerError to set
	 */
	public void setCompilerError(String compilerError) {
		this.compilerError = compilerError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Solution o) {
		return submitNumber  - o.submitNumber;
	}
}
