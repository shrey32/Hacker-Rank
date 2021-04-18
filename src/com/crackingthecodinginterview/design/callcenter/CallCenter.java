package com.crackingthecodinginterview.design.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class CallCenter implements OnCallArrival, CallDispatcher {

	private static CallCenter instance;

	private final List<Employee> employees;
	private final Queue<Employee> availableRespondents;

	private CallCenter() {
		this.employees = new ArrayList<>();
		this.availableRespondents = new LinkedList<>();
	}

	public void addNewEmployee(Employee employee) {
		this.employees.add(employee);
		// initially add every new employee who is a respondent to the call
		this.addAvailableRespondent(employee);
	}

	public List<Employee> getAllEmployees() {
		return List.copyOf(this.employees);
	}

	public void addAvailableRespondent(Employee employee) {
		if (employee.getType() == EmployeeType.RESPONDENT)
			this.availableRespondents.offer(employee);
	}

	@Override
	public void onCallArrival(Call call) {
		System.out.println("Call Arrived with number " + call.getIncomingNumber());
		Employee employee = this.availableRespondents.poll();
		this.dispatchCall(employee, call);
	}

	@Override
	public void dispatchCall(Employee employee, Call call) {
		if (employee == null)
			throw new RuntimeException("All our staff are busy at the moment, please hold or try again later!");
		if (employee.isAvailable()) {
			// handle call
			employee.setIsAvailable(false);
			System.err.println(employee.getFirstName() + " " + employee.getLastName() + " is handling "
					+ call.getIncomingNumber());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			employee.setIsAvailable(true);
			System.err.println(employee.getFirstName() + " " + employee.getLastName() + " is available again!!!");
			// add employee back to queue
			this.addAvailableRespondent(employee);
			return;
		}
		System.err.println(employee.getFirstName() + " " + employee.getLastName() + " is not available to handle "
				+ call.getIncomingNumber());
		System.err.println("Dispatching the Call to his/her Manager");
		dispatchCall(employee.getManager(), call);
	}

	public static CallCenter getInstance() {
		if (instance == null)
			instance = new CallCenter();
		return instance;
	}

}
