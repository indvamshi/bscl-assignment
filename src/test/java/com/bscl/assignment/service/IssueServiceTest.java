package com.bscl.assignment.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bscl.assignment.domain.Issue;
import com.bscl.assignment.domain.Priority;
import com.bscl.assignment.repository.IssueRepository;
import com.bscl.assignment.service.impl.IssueServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest {

	@InjectMocks
	private IssueServiceImpl issueService = new IssueServiceImpl();
	
	@Mock
	private IssueRepository issueRepository;
	
	@Test
	public void testCreateIssue() {

		Issue issue = new Issue("summary1", "desc1" , "ctg1", Priority.HIGH);
		Mockito.when(issueRepository.saveIssue(issue)).thenReturn(issue);
		
		Issue createIssue = issueService.createIssue(issue);
		
		Assert.assertNotNull(createIssue);
		Mockito.verify(issueRepository).saveIssue(issue);
		Mockito.verifyNoMoreInteractions(issueRepository);
	}
}
