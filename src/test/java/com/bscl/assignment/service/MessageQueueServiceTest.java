package com.bscl.assignment.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bscl.assignment.domain.Message;
import com.bscl.assignment.exception.InvalidMessageException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/application-context.xml")
@FixMethodOrder(MethodSorters.JVM)
public class MessageQueueServiceTest {

    @Autowired
    private MessageQueueServiceImpl messageQueueService;
	
	@Test
	public void testAddMessage() {
		Message message = new Message(new Integer(1), new Integer(1), 
				new Integer(1), new Integer(1), new Integer(101));
		
		Assert.assertNotNull(messageQueueService.pushMessage(message));
	}
	
	@Test
	public void testCountMessages() {
		
		Message message = new Message(new Integer(2), new Integer(1), 
				new Integer(1), new Integer(1), new Integer(101));
		
		messageQueueService.pushMessage(message);
		
		Assert.assertEquals(2, messageQueueService.countMessages());
	}
	
	@Test
	public void testHeadMessages() {
		
		Message message = new Message(new Integer(3), new Integer(1), 
				new Integer(1), new Integer(1), new Integer(101));
		
		messageQueueService.pushMessage(message);
		
		Message headMessage = messageQueueService.getHeadMessage();
		Assert.assertEquals(1, headMessage.getInstructionType().intValue());
	}
	
	@Test
	public void testPopMessage() {
		Message message = new Message();
		message.setInstructionType(1);

		messageQueueService.popMessage(message);
		
		Assert.assertEquals(2, messageQueueService.countMessages());
	}
	
	@Test
	public void testQEmpty() {
		Message message = new Message();
		message.setInstructionType(2);

		messageQueueService.popMessage(message);
		
		message = new Message();
		message.setInstructionType(3);
		
		messageQueueService.popMessage(message);
		
		Assert.assertTrue(messageQueueService.isEmpty());
	}
	
	/*
	 *  validate message. If it is valid then throw exception
	 */
	@Test(expected = InvalidMessageException.class)
	public void testValidateMessage() {
		Message message = new Message(new Integer(0), new Integer(1), 
				new Integer(1), new Integer(1), new Integer(101));

		messageQueueService.pushMessage(message);
	}
	
	/*
	 *  validate message. If it is valid then throw exception
	 */
	@Test(expected = InvalidMessageException.class)
	public void testValidateMessageWithNegativeValue() {
		Message message = new Message(new Integer(-1), new Integer(1), 
				new Integer(1), new Integer(1), new Integer(101));

		messageQueueService.pushMessage(message);
	}
	
	/*
	 *  test if messages are queued based on priority
	 */
	@Test
	public void testPriority() {
		
		// set instruction type to 3
		Message message = new Message(new Integer(3), new Integer(1033), 
				new Integer(33), new Integer(145), new Integer(030313));

		messageQueueService.pushMessage(message);
		
		// set instruction type to 31
		message = new Message(new Integer(31), new Integer(10331), 
				new Integer(331), new Integer(150), new Integer(040313));

		messageQueueService.pushMessage(message);
		
		// set instruction type to 1
		message = new Message(new Integer(1), new Integer(101), 
				new Integer(101), new Integer(101), new Integer(101));

		messageQueueService.pushMessage(message);
		
		// set instruction type to 2
		message = new Message(new Integer(2), new Integer(202), 
				new Integer(22), new Integer(212), new Integer(02022013));

		messageQueueService.pushMessage(message);
		
		Message headMessage = messageQueueService.getHeadMessage();
		
		// should get the highest priority message i.e in this case the instruction type is 1
		Assert.assertEquals(1, headMessage.getInstructionType().intValue());
		Assert.assertEquals(101, headMessage.getProductCode().intValue());
	}
}
