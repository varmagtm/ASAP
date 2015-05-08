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
public class AssessmentSchedule implements Comparable<AssessmentSchedule>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int scheduleId;
	private Group group;
	private Problem problem;
	private Date startDate;
	private Date endDate;
	private boolean enable;

	/**
	 * 
	 */
	public AssessmentSchedule() {
		super();
	}

	/**
	 * @param scheduleId
	 * @param group
	 * @param problem
	 * @param startDate
	 * @param endDate
	 * @param enable
	 */
	public AssessmentSchedule(int scheduleId, Group group, Problem problem,
			Date startDate, Date endDate, boolean enable) {
		super();
		this.scheduleId = scheduleId;
		this.group = group;
		this.problem = problem;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enable = enable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssessmentSchedule [enable=" + enable + ", endDate=" + endDate
				+ ", group=" + group + ", problem=" + problem + ", scheduleId="
				+ scheduleId + ", startDate=" + startDate + "]";
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
		result = prime * result + (enable ? 1231 : 1237);
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + scheduleId;
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		AssessmentSchedule other = (AssessmentSchedule) obj;
		if (enable != other.enable)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	/**
	 * @return the scheduleId
	 */
	public int getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId
	 *            the scheduleId to set
	 */
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the enable
	 */
	public boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AssessmentSchedule o) {
		return scheduleId - o.scheduleId;
	}

}
