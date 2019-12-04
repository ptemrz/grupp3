package vp;

import java.util.ArrayList;
import java.util.List;

public class Videopoker {

	Deck deck = new Deck();

	List<Card> hand = new ArrayList<>();

	public void resetGame() {

		deck.shuffle();

		while (hand.size() < 5) {
			hand.add(deck.draw());
		}
	}

	/**
	 * Checks if the given hand is a full house
	 * 
	 * @return true iff the hand is a full house
	 * @param hand must be a sorted list of cards
	 */
	private boolean isFullHouse(List<Card> hand) {

		if (! (hand.get(0).getValue() == hand.get(1).getValue())) {
			return false;
		}
		
		if (! (hand.get(4).getValue() == hand.get(3).getValue())) {
			return false;
		}
		
		if (! (hand.get(3).getValue() == hand.get(2).getValue()) || hand.get(2).getValue() == hand.get(1).getValue()) {
			return false;
		}

		return true;
	}
}
