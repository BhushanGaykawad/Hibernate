package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	
	
	
	
	
	@Id
	@Column(name="cid",length=5)
	private String cid;
	@Column(name="cname",length=10)
	private String cname;
	@Column(name="ccost",length=15)
	private int ccost;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcost() {
		return ccost;
	}
	public void setCcost(int ccost) {
		this.ccost = ccost;
	}
	

}
