package com.vlm.oracletutorial.classesandobjects;

public class CardDeckEnum {

	private int numberOfRanks = 13;
	private int numberOfSuits = 4;
	private int suitCount = 1;
	private int rankCount = 1;
	
	private CardEnum[][] deck = new CardEnum[numberOfSuits][numberOfRanks];
		public CardDeckEnum() {
			//Create an Array of cards and put one of each card inside it
			for (CardSuit suit: CardSuit.values()) {
				rankCount = 1;
				for (CardRank rank: CardRank.values()) {
					deck[suitCount - 1][rankCount - 1] = new CardEnum(suit, rank);
					System.out.println(deck[suitCount-1][rankCount-1]);
					rankCount += 1;
				}
				suitCount += 1;
			}
			
		}
		
		public String toString() {
			String printString = "Deck of Cards: \n";
		
			for (CardEnum[] aSuit : deck) {
				for (CardEnum aCard: aSuit) {
					printString += aCard + "\n";
				}
			}
			return printString;
		}
}
