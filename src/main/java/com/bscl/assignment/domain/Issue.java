package com.bscl.assignment.domain;

public class Issue implements Comparable<Issue>{

	private Integer issueNumber;
	
	private String summary;
	
	private String description;
	
	private String category;
	
	private Priority priority;
	
	public Issue() {
	}
	
	public Issue(String summary, String description, String category, Priority priority) {
		this.summary = summary;
		this.description = description;
		this.category = category;
		this.priority = priority;
	}

	public Integer getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((issueNumber == null) ? 0 : issueNumber.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Issue)) {
			return false;
		}
		Issue other = (Issue) obj;
		if (issueNumber == null) {
			if (other.issueNumber != null) {
				return false;
			}
		} else if (!issueNumber.equals(other.issueNumber)) {
			return false;
		}
		if (priority != other.priority) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Issue issue) {
		return issue.getIssueNumber() - this.getIssueNumber();
	}
	
	

}
