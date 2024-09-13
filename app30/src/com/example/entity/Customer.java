package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends Person {

	@Column(name="cid")
	private String cid;
	@Column(name="cmobile")
	private String cmobile;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCmobile() {
		return cmobile;
	}
	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}
	
}
