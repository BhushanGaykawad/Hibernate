package com.example.entity;


public class ChequePayment extends Payment {
	
	private int cheque_No;
	private String accNo;
	
	public int getCheque_No() {
		return cheque_No;
	}
	public void setCheque_No(int cheque_No) {
		this.cheque_No = cheque_No;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
}
