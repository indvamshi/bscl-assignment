package com.bscl.assignment.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.bscl.assignment.domain.Issue;
import com.bscl.assignment.repository.IssueRepository;

public class IssueRepositoryImpl implements IssueRepository {

	public static final Set<Issue> issueList = new HashSet<Issue>();
	
	public static int issueId = 1;
	
	@Override
	public Issue saveIssue(Issue issue) {
		issue.setIssueNumber(issueId+1);
		issueList.add(issue);
		
		return issue;
	}

	@Override
	public Set<Issue> getIssues() {
		return issueList;
	}

}
