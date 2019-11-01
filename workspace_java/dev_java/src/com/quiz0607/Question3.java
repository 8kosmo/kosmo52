package com.quiz0607;
//접근제한자
class CreditCard{
	private String cardID;
	private Integer limit;
	public String ownerName;
	public void setCardInformation(String cardID,String ownerName, Integer limit) {
			this.cardID = cardID;
			this.ownerName = ownerName;
			this.limit = limit;
	}
}
public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
