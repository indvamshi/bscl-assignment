package com.bscl.assignment.repository;

import java.util.Set;

import com.bscl.assignment.domain.Issue;

public interface IssueRepository {

	Issue saveIssue(Issue issue);
	
	Set<Issue> getIssues();
}
