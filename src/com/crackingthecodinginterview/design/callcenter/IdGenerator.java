package com.crackingthecodinginterview.design.callcenter;

public class IdGenerator {

	private static Long employeeId = 0L;
	private static Long callId = 0L;

	public static Long generateAndGetEmployeeId() {
		employeeId++;
		return employeeId;
	}

	public static Long generateAndGetCallId() {
		callId++;
		return callId;
	}

}
