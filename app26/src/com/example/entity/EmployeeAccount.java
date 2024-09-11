package com.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("emp")
public class EmployeeAccount extends Account {
	
	@Column(name="EID")
	private String eid;
	@Column(name="ESAL")
	private float esal;
	@Column(name="EADDR")
	private String eaddr;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
}
