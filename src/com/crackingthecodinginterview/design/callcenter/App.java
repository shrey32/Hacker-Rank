package com.crackingthecodinginterview.design.callcenter;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class App {

	public static void main(String[] args) {
		CallCenter callCenter = init();
		for (String number : samplePhoneNumbers()) {
			callCenter.onCallArrival(new Call(number));
		}
	}

	private static CallCenter init() {
		CallCenter callCenter = CallCenter.getInstance();
		Employee director = new Employee("Jeff", "Bezos", EmployeeType.DIRECTOR, null);
		Employee manager1 = new Employee("Andy", "Jassy", EmployeeType.MANAGER, director);
		Employee manager2 = new Employee("Amit", "Agarwal", EmployeeType.MANAGER, director);
		Employee respondent1 = new Employee("John", "Doe", EmployeeType.RESPONDENT, manager1);
		Employee respondent2 = new Employee("Jessica", "Simpson", EmployeeType.RESPONDENT, manager2);
		Employee respondent3 = new Employee("Jacob", "Kramly", EmployeeType.RESPONDENT, manager1);
		Employee respondent4 = new Employee("Katie", "Powell", EmployeeType.RESPONDENT, manager2);
		callCenter.addNewEmployee(director);
		callCenter.addNewEmployee(manager1);
		callCenter.addNewEmployee(manager2);
		callCenter.addNewEmployee(respondent1);
		callCenter.addNewEmployee(respondent2);
		callCenter.addNewEmployee(respondent3);
		callCenter.addNewEmployee(respondent4);
		respondent2.setIsAvailable(false);
		respondent3.setIsAvailable(false);
		return callCenter;
	}

	private static List<String> samplePhoneNumbers() {
		return Arrays.asList("7878833223", "89839893", "9898989888", "837837287", "6523656235");
	}

}
