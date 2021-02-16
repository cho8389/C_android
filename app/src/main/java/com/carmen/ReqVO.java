package com.carmen;

import java.util.Date;

public class ReqVO extends Criteria{
	private int ordreq_id;
	private String emp_id;
	private Date ordreq_date;
	private Date ordreq_edate;
	private String ordreq_customer;
	private String ordreq_name;
	private int ordreq_amount;
	private String ordreq_purchase;
	private int ordreq_price;
	private int ordreq_cost;
	private String ordreq_region;
	private String ordreq_state;
	private String ordreq_type;
	private Date ordreq_date_e;
	public int getOrdreq_id() {
		return ordreq_id;
	}
	public void setOrdreq_id(int ordreq_id) {
		this.ordreq_id = ordreq_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public Date getOrdreq_date() {
		return ordreq_date;
	}
	public void setOrdreq_date(Date ordreq_date) {
		this.ordreq_date = ordreq_date;
	}
	public Date getOrdreq_edate() {
		return ordreq_edate;
	}
	public void setOrdreq_edate(Date ordreq_edate) {
		this.ordreq_edate = ordreq_edate;
	}
	public String getOrdreq_customer() {
		return ordreq_customer;
	}
	public void setOrdreq_customer(String ordreq_customer) {
		this.ordreq_customer = ordreq_customer;
	}
	public String getOrdreq_name() {
		return ordreq_name;
	}
	public void setOrdreq_name(String ordreq_name) {
		this.ordreq_name = ordreq_name;
	}
	public int getOrdreq_amount() {
		return ordreq_amount;
	}
	public void setOrdreq_amount(int ordreq_amount) {
		this.ordreq_amount = ordreq_amount;
	}
	public String getOrdreq_purchase() {
		return ordreq_purchase;
	}
	public void setOrdreq_purchase(String ordreq_purchase) {
		this.ordreq_purchase = ordreq_purchase;
	}
	public int getOrdreq_price() {
		return ordreq_price;
	}
	public void setOrdreq_price(int ordreq_price) {
		this.ordreq_price = ordreq_price;
	}
	public int getOrdreq_cost() {
		return ordreq_cost;
	}
	public void setOrdreq_cost(int ordreq_cost) {
		this.ordreq_cost = ordreq_cost;
	}
	public String getOrdreq_region() {
		return ordreq_region;
	}
	public void setOrdreq_region(String ordreq_region) {
		this.ordreq_region = ordreq_region;
	}
	public String getOrdreq_state() {
		return ordreq_state;
	}
	public void setOrdreq_state(String ordreq_state) {
		this.ordreq_state = ordreq_state;
	}
	public String getOrdreq_type() {
		return ordreq_type;
	}
	public void setOrdreq_type(String ordreq_type) {
		this.ordreq_type = ordreq_type;
	}
	public Date getOrdreq_date_e() {
		return ordreq_date_e;
	}
	public void setOrdreq_date_e(Date ordreq_date_e) {
		this.ordreq_date_e = ordreq_date_e;
	}
	public ReqVO() {}
	public ReqVO(int ordreq_id, String emp_id, Date ordreq_date, Date ordreq_edate, String ordreq_customer,
			String ordreq_name, int ordreq_amount, String ordreq_purchase, int ordreq_price, int ordreq_cost,
			String ordreq_region, String ordreq_state, String ordreq_type, Date ordreq_date_e) {
		super();
		this.ordreq_id = ordreq_id;
		this.emp_id = emp_id;
		this.ordreq_date = ordreq_date;
		this.ordreq_edate = ordreq_edate;
		this.ordreq_customer = ordreq_customer;
		this.ordreq_name = ordreq_name;
		this.ordreq_amount = ordreq_amount;
		this.ordreq_purchase = ordreq_purchase;
		this.ordreq_price = ordreq_price;
		this.ordreq_cost = ordreq_cost;
		this.ordreq_region = ordreq_region;
		this.ordreq_state = ordreq_state;
		this.ordreq_type = ordreq_type;
		this.ordreq_date_e = ordreq_date_e;
	}
	@Override
	public String toString() {
		return "ReqVO [ordreq_id=" + ordreq_id + ", emp_id=" + emp_id + ", ordreq_date=" + ordreq_date
				+ ", ordreq_edate=" + ordreq_edate + ", ordreq_customer=" + ordreq_customer + ", ordreq_name="
				+ ordreq_name + ", ordreq_amount=" + ordreq_amount + ", ordreq_purchase=" + ordreq_purchase
				+ ", ordreq_price=" + ordreq_price + ", ordreq_cost=" + ordreq_cost + ", ordreq_region=" + ordreq_region
				+ ", ordreq_state=" + ordreq_state + ", ordreq_type=" + ordreq_type + ", ordreq_date_e=" + ordreq_date_e
				+ "]";
	}
}
