package com.bscl.assignment.service;

import org.junit.Assert;
import org.junit.Test;

import com.bscl.assignment.domain.Issue;
import com.bscl.assignment.domain.Priority;
import com.bscl.assignment.repository.IssueRepository;
import com.bscl.assignment.repository.impl.IssueRepositoryImpl;

public class IssueRepositoryServiceTest {

	@Test
	public void testSaveIssue() {
		IssueRepository issueRepository = new IssueRepositoryImpl();
		
		Issue issue = new Issue("summary1", "desc1" , "ctg1", Priority.HIGH);
		Issue newIssue = issueRepository.saveIssue(issue);
		
		Assert.assertNotNull(newIssue);
		
		issue =	new Issue("summary2", "desc2" , "ctg2", Priority.MEDIUM);
		issueRepository.saveIssue(issue);
		
		issue =	new Issue("summary2", "desc2" , "ctg2", Priority.LOW);
		issueRepository.saveIssue(issue);

	}
	
	@Test
	public void testGetIssues() {
		
	}
	
}
