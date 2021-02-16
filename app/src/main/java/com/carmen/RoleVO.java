package com.carmen;

public class RoleVO {
	private String emp_id;
	private String role;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleVO() {}
	public RoleVO(String emp_id, String role) {
		super();
		this.emp_id = emp_id;
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleVO [emp_id=" + emp_id + ", role=" + role + "]";
	}
}
