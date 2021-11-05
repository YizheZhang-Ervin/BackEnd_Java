package com.ervin.EZSpring.WebEntrance.JMS.Message;

public class RegistrationMessage extends AbstractMessage {

	public static RegistrationMessage of(Integer userId, String name) {
		RegistrationMessage msg = new RegistrationMessage();
		msg.userId = userId;
		msg.name = name;
		msg.timestamp = System.currentTimeMillis();
		return msg;
	}

	@Override
	public String toString() {
		return String.format("[RegistrationMessage: email=%s, name=%s, timestamp=%s]", userId, name, timestamp);
	}
}
