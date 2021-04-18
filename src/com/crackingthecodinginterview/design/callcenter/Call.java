package com.crackingthecodinginterview.design.callcenter;

public class Call {

	private long id;
	private String incomingNumber;

	public Call(String incomingNumber) {
		this.id = IdGenerator.generateAndGetCallId();
		this.incomingNumber = incomingNumber;
	}

	public long getId() {
		return id;
	}

	public String getIncomingNumber() {
		return incomingNumber;
	}

}
