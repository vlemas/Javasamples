package com.vlm.oracletutorial.classesandobjects;

public class CardPlay {

	public static void main(String[] args) {
		Card threeOfClubs  = new Card (Card.CLUBS, Card.THREE);
		assert threeOfClubs.suitToString() == "Clubs   ";
		assert threeOfClubs.rankToString() == "Three  ";
		

		Card queenOfSpades  = new Card (Card.SPADES, Card.QUEEN);
		assert queenOfSpades.suitToString() == "Spades  ";
		assert queenOfSpades.rankToString() == "Queen  ";

		Card aceOfHearts  = new Card (Card.HEARTS, Card.ACE);
		assert aceOfHearts.suitToString() == "Hearts  ";
		assert aceOfHearts.rankToString() == "Ace    ";

		Card eightOfDiamonds  = new Card (Card.DIAMONDS, Card.EIGHT);
		assert eightOfDiamonds.suitToString() == "Diamonds";
		assert eightOfDiamonds.rankToString() == "Eight  ";
		
		System.out.println(threeOfClubs);
		System.out.println(queenOfSpades);
		System.out.println(aceOfHearts);
		System.out.println(eightOfDiamonds);
	}
	

}
