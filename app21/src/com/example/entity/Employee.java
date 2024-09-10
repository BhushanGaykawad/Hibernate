package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="emp1")
public class Employee {
	@Id
	@Column(name="eno")
	@TableGenerator(name="tableGenerator",table="my_table",pkColumnName="id",pkColumnValue="10", valueColumnName="next_hi")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tableGenerator")
	private int eno;
	
//	private String eid;
	@Column(name="ename")
	private String ename;
	
	@Column(name="esal")
	private float esal;
	@Column(name="eaddr")
	private String eaddr;
	
	public int getEno() {
		return eno;
	}
	
	public void setEno(int eno) {
		this.eno = eno;
	}
	
//	public String getEid() {
//		return eid;
//	}
//	public void setEid(String eid) {
//		this.eid = eid;
//	} 
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
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
