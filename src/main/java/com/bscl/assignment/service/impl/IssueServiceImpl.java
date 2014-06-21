package com.bscl.assignment.service.impl;

import com.bscl.assignment.domain.Issue;
import com.bscl.assignment.repository.IssueRepository;
import com.bscl.assignment.service.IssueService;

public class IssueServiceImpl implements IssueService {

	// practically the repository bean is injected using DI pattern eg: Spring IOC
	private IssueRepository issueRepository;
	
	@Override
	public Issue createIssue(Issue issue) {
		return issueRepository.saveIssue(issue);
	}

}
