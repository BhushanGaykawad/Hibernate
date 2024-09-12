package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="payment")
@Inheritance(strategy=InheritanceType.JOINED)
public class Payment {

	@Id
	@Column(name="TX_ID")
	private String tx_Id;
	@Column(name="PAY_DATE")
	private String pay_Date;
	
	@Column(name="PAY_AMT")
	private int pay_Amt;
	
	public String getTx_Id() {
		return tx_Id;
	}
	public void setTx_Id(String tx_Id) {
		this.tx_Id = tx_Id;
	}
	public String getPay_Date() {
		return pay_Date;
	}
	public void setPay_Date(String pay_Date) {
		this.pay_Date = pay_Date;
	}
	public int getPay_Amt() {
		return pay_Amt;
	}
	public void setPay_Amt(int pay_Amt) {
		this.pay_Amt = pay_Amt;
	}
	
	
}
