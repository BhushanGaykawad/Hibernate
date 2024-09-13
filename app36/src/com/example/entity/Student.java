package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="SID", length=5)
	private String sid;
	
	@Column(name="SNAME",length=14)
	private String sname;
	
	@Column(name="SADDR", length=13)
	private String saddr;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Branch branch;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
}
