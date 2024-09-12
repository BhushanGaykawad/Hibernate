package com.example.entity;

public class CardPayment extends Payment {

	private int card_No;
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
