package com.spring.jms.sender.api.service;

import java.io.Serializable;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.spring.jms.sender.api.dao.UserDAO;
import com.spring.jms.sender.api.model.User;

@Service
public class UserService {
	@Autowired
	private JmsTemplate template;
	@Autowired
	private UserDAO dao;

	private List<User> getUsers() {
		return dao.getUsers();
	}

	public int sendUsers() {
		List<User> users = getUsers();
		template.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage message = session.createObjectMessage();
				message.setObject((Serializable) users);
				return message;
			}
		});
		return users.size();
	}

}
