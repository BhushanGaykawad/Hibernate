package com.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("std")
public class StudentAccount extends Account {

	@Column(name="SID")
	private String sid;
	@Column(name="SBRANCH")
	private String sbranch;
	@Column(name="SMARKS")
	private int smarks;
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSbranch() {
		return sbranch;
	}
	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	
	
	
}
