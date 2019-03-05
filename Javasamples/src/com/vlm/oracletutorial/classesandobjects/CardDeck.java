package com.vlm.oracletutorial.classesandobjects;

public class CardDeck {

	int numberOfRanks = 13;
	int numberOfSuits = 4;
	private Card[][] deck = new Card[numberOfSuits][numberOfRanks];
		public CardDeck() {
			//Create an Array of cards and put one of each card inside it
			for (int suit = 1; suit <= numberOfSuits; suit++) {
				for (int rank = 1; rank <= numberOfRanks; rank++) {
					deck[suit-1][rank-1] = new Card(suit, rank);
					System.out.println(deck[suit-1][rank-1]);
					
				}
			}
			
		}
		
		public String toString() {
			String printString = "Deck of Cards: \n";
		
			for (Card[] aSuit : deck) {
				for (Card aCard: aSuit) {
					printString += aCard + "\n";
				}
			}
			return printString;
		}
}
