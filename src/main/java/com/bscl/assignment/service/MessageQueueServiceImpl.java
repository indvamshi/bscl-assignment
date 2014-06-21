package com.bscl.assignment.service;

import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bscl.assignment.domain.Message;
import com.bscl.assignment.exception.InvalidMessageException;


/**
 * Incoming instruction messages are stored in this queue.
 * 
 * @author vchitti
 *
 */
@Service
public class MessageQueueServiceImpl implements IMessageQueueService {

	private static final PriorityBlockingQueue<Message> messageQueue = new PriorityBlockingQueue<Message>();
	
	@Autowired
	private Validator validator;
	
	@Override
	public int countMessages() {
		return messageQueue.size();
	}
	
	@Override
	public Message pushMessage(@Valid Message message) {
		if(!validate(message)) {
			throw new InvalidMessageException("Invalid Message");
		}
		messageQueue.add(message);
		
		return message;
	}
	
	@Override
	public void popMessage(Message message) {
		messageQueue.remove(message);
	}
	
	@Override
	public Message getHeadMessage() {
		return messageQueue.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return messageQueue.isEmpty();
	}
	
	private boolean validate(Message message) {
		Set<ConstraintViolation<Message>> validate = validator.validate(message, Default.class);
		return validate.size() == 0 ? true : false;
	}
	
}
