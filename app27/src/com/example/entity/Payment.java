package com.example.entity;

public class Payment {

	private String tx_Id;
	private String pay_Date;
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
