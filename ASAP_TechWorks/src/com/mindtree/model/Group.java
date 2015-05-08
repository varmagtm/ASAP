/**
 * 
 */
package com.mindtree.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author m1012679
 * 
 */
public class Group implements Comparable<Group>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int groupId;
	private String name;
	private Set<Candidate> candidates = new HashSet<Candidate>();

	/**
	 * 
	 */
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param groupId
	 * @param name
	 */
	public Group(int groupId, String name) {
		super();
		this.groupId = groupId;
		this.name = name;
	}

	/**
	 * @return the candidates
	 */
	public Set<Candidate> getCandidates() {
		return candidates;
	}

	/**
	 * @param candidates the candidates to set
	 */
	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", name=" + name + "]";
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
		result = prime * result + groupId;
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
		Group other = (Group) obj;
		if (groupId != other.groupId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
	public int compareTo(Group o) {
		return groupId-o.groupId;
	}
}
