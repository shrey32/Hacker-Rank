package com.crackingthecodinginterview.design.callcenter;

/**
 * 
 * @author Shrey
 *
 */
public class Employee {

	private long employeeId;
	private String firstName, lastName;
	private EmployeeType type;
	private boolean isAvailable = true;
	private Employee manager;

	public Employee(String firstName, String lastName, EmployeeType type, Employee manager) {
		this.employeeId = IdGenerator.generateAndGetEmployeeId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.manager = manager;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public EmployeeType getType() {
		return type;
	}

	public Employee getManager() {
		return this.manager;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
}
