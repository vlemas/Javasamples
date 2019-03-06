package com.vlm.oracletutorial.classesandobjects;

public class CardEnum {
	
	private CardSuit suit;
	private CardRank rank;
	
	public CardEnum(CardSuit suit, CardRank rank) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public CardRank getRank() {
		return this.rank;
	}
	
	public CardSuit getSuit() {
		return this.suit;
	}
	public String suitToString() {
		switch (this.suit) {
		case CLUBS: return "Clubs   ";
		case HEARTS: return "Hearts  ";
		case SPADES: return "Spades  ";
		case DIAMONDS: return "Diamonds";
		
		default: return "";
		}
	}

	public String rankToString() {
		
		switch (this.rank) {
		case ACE: return "Ace    ";
		case TWO: return "Two    ";
		case THREE: return "Three  ";
		case FOUR: return "Four   ";
		case FIVE: return "Five   ";
		case SIX: return "Six    ";
		case SEVEN: return "Seven  ";
		case EIGHT: return "Eight  ";
		case NINE: return "Nine   ";
		case TEN: return "Ten    ";
		case JACK: return "Jack   ";
		case QUEEN: return "Queen  ";
		case KING: return "King   ";
		
		default: return "";
		}
	}
	
	public String toString() {
		return rankToString() + " of " + suitToString();
	}
}
