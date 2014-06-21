package com.bscl.assignment.service;

import com.bscl.assignment.domain.Message;

/**
 * @author vchitti
 *
 */
public interface IMessageQueueService {

	/**
	 * count number of messages in queue
	 * 
	 * @return the count
	 */
	public int countMessages();
	
	/**
	 * push message into queue
	 * @param message {@code Message} which is placed into queue
	 * @return {@code Message}
	 */
	public Message pushMessage(Message message);
	
	/**
	 * remove message from queue
	 * @param message
	 */
	public void popMessage(Message message);
	
	/**
	 * get first message from the queue
	 * @param message this message is compared with {@code Message) in the queue
	 * @return {@code Message} return the head message i.e first message in the queue
	 */
	public Message getHeadMessage();
	
	/**
	 * check if queue is empty
	 * @return boolean if queue is empty return true else false
	 */
	public boolean isEmpty();
	
}
