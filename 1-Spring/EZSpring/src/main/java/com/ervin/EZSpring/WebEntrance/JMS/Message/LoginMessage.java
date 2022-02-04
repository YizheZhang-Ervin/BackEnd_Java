package com.ervin.EZSpring.WebEntrance.JMS.Message;

public class LoginMessage extends AbstractMessage {

	public boolean success;

	public static LoginMessage of(Integer userId, String name, boolean success) {
		LoginMessage msg = new LoginMessage();
		msg.userId = userId;
		msg.name = name;
		msg.success = success;
		msg.timestamp = System.currentTimeMillis();
		return msg;
	}

	@Override
	public String toString() {
		return String.format("[LoginMessage: email=%s, name=%s, success=%s, timestamp=%s]", userId, name, success,
				timestamp);
	}
}
