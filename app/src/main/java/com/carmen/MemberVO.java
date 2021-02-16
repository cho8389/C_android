package com.carmen;

public class MemberVO {
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private String emp_title;
	private String enabled;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_title() {
		return emp_title;
	}
	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public MemberVO() {}
	public MemberVO(String emp_id, String emp_pw, String emp_name, String emp_title, String enabled) {
		super();
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.emp_name = emp_name;
		this.emp_title = emp_title;
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "MemberVO [emp_id=" + emp_id + ", emp_pw=" + emp_pw + ", emp_name=" + emp_name + ", emp_title="
				+ emp_title + ", enabled=" + enabled + "]";
	};
}
