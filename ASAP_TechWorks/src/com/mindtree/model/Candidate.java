/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;

/**
 * @author m1012679
 * 
 */
public class Candidate implements Comparable<Candidate>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int candidateId;
	private User user;
	private String employeeId;
	private String name;
	private Group group = new Group();

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * 
	 */
	public Candidate() {
		super();
	}

	/**
	 * @param candidateId
	 * @param userId
	 * @param mId
	 * @param name
	 */
	public Candidate(int candidateId, User userId, String mId, String name) {
		super();
		this.candidateId = candidateId;
		this.user = userId;
		employeeId = mId;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidate [MId=" + employeeId + ", candidateId=" + candidateId
				+ ", name=" + name + ", userId=" + user + "group : " + group +  "]";
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
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + candidateId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Candidate other = (Candidate) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return the candidateId
	 */
	public int getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId
	 *            the candidateId to set
	 */
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	/**
	 * @return the userId
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUser(User userId) {
		this.user = userId;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Candidate o) {
		return candidateId - o.candidateId;
	}
}
