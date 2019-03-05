package com.vlm.oracletutorial.classesandobjects;

public class Card {
	
	
	public static final int CLUBS = 1;
	public static final int HEARTS = 2;
	public static final int SPADES = 3;
	public static final int DIAMONDS = 4;
	
	public static final int ACE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	private int suit;
	private int rank;
	
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getRank() {
		return this.rank;
	}
	
	public int getSuit() {
		return this.suit;
	}
	
	public String suitToString() {
		switch (this.suit) {
		case 1: return "Clubs   ";
		case 2: return "Hearts  ";
		case 3: return "Spades  ";
		case 4: return "Diamonds";
		
		default: return "";
		}
	}

	public String rankToString() {
		
		switch (this.rank) {
		case 1: return "Ace    ";
		case 2: return "Two    ";
		case 3: return "Three  ";
		case 4: return "Four   ";
		case 5: return "Five   ";
		case 6: return "Six    ";
		case 7: return "Seven  ";
		case 8: return "Eight  ";
		case 9: return "Nine   ";
		case 10: return "Ten    ";
		case 11: return "Jack   ";
		case 12: return "Queen  ";
		case 13: return "King   ";
		
		default: return "";
		}
	}
	
	public String toString() {
		return rankToString() + " of " + suitToString();
	}

}
