package com.zx.service;

import java.util.Date;

import com.entity.Message;
import com.zx.dao.MessageDao;

public class MessageService {
	Message message;	
	MessageDao messageDao;
	
	
	public void  save(String mcontent,String name,String phone,String email) {
		message.setEmail(email);
		message.setMcontent(mcontent);
		message.setMtime(new Date());
		message.setName(name);
	    message.setPhone(phone);
		//messageDao.setCheckWriteOperations(false);
		messageDao.save(message);
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public MessageDao getMessageDao() {
		return messageDao;
	}
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
}
