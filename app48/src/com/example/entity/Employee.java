package com.example.entity;

/* 
	create function getEmployees return SYS_REFCURSOR
	as
	employees SYS_REF_CURSOR;
	BEGIN
	open employees for
		select * from emp1;
	return employees;
	END getEmployee;
 

 * */

public class Employee {
	private int eno;
	private String ename;
	private String eaddr;
	private float esal;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	
}
