package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="card_payment")
@PrimaryKeyJoinColumn(name="TX_ID")
public class CardPayment extends Payment {

	@Column(name="card_no")
	private int card_No;
	@Column(name="expr_Date")
	private String expr_Date;
	
	public int getCard_No() {
		return card_No;
	}
	public void setCard_No(int card_No) {
		this.card_No = card_No;
	}
	public String getExpr_Date() {
		return expr_Date;
	}
	public void setExpr_Date(String expr_Date) {
		this.expr_Date = expr_Date;
	}
	
}
