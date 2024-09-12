package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payment")
@PrimaryKeyJoinColumn(name="TX_ID")
public class ChequePayment extends Payment {
	
	@Column(name="cheque_no")
	private int cheque_No;
	
	@Column(name="acct_no")
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
