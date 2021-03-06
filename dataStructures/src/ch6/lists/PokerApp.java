package ch6.lists;

import support.RankCardDeck;

public class PokerApp {
	public static void main(String[] args) {
		final int HANDSIZE = 7;
		final int NUMHANDS = 1000000;
		int numPairs = 0;
		boolean isPair;
		float probability;
		UnsortedListInterface hand;
		RankCardDeck deck = new RankCardDeck();
		int card;
		for(int i=0; i<NUMHANDS; i++){
			deck.shuffle();
			hand = new ArrayUnsortedList(HANDSIZE);
			isPair = false;
			for(int j=0; j<HANDSIZE; j++){
				card = deck.nextCard();
				if(hand.contains(card))
					isPair = true;
				hand.add(card);				
			}
			if(isPair)
				numPairs = numPairs + 1;
		}
		probability = numPairs/(float)NUMHANDS;
		System.out.println();
		System.out.print("There were " + numPairs + " hands out of " + NUMHANDS);
		System.out.println(" that had at least one pair of matched cards.");
		System.out.print("The probability of getting at least one pair");
		System.out.print(" based on this simulation, is ");
		System.out.println(probability);
	}
}
