package vp;

import java.util.ArrayList;
import java.util.List;

public class Videopoker {

	Deck deck = new Deck();

	List<Card> hand = new ArrayList<>();

	public void resetGame() {

		deck.shuffle();
		hand.clear();
		while (hand.size() < 5) {
			hand.add(deck.draw());
		}
	}

	/**
	 * Checks if the given hand is a full house
	 * 
	 * @return true if the hand is a full house
	 * @param hand must be a sorted list of cards
	 */
	private boolean isFullHouse(List<Card> hand) {

		if (!(hand.get(0).getValue() == hand.get(1).getValue())) {
			return false;
		}

		if (!(hand.get(4).getValue() == hand.get(3).getValue())) {
			return false;
		}

		if (!(hand.get(3).getValue() == hand.get(2).getValue()) || hand.get(2).getValue() == hand.get(1).getValue()) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if the given hand is a three of a kind
	 * 
	 * @return true if the hand is a three of a kind
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */
	private boolean isThreeOfAKind(List<Card> hand) {

		if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == hand.get(2).getValue()) {
			return true;
		}

		if (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(1).getValue() == hand.get(3).getValue()) {
			return true;
		}

		if (hand.get(2).getValue() == hand.get(3).getValue() && hand.get(2).getValue() == hand.get(4).getValue()) {
			return true;
		}

		return false;

	}

	/**
	 * Checks if the given hand is a Double pair
	 * 
	 * @return true if the hand is a JQKA-pair
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */
	private boolean isDoublePair(List<Card> hand) {
		if ((hand.get(0).getValue() == hand.get(1).getValue()) && (hand.get(2).getValue() == hand.get(3).getValue())) {
			return true;
		}
		if ((hand.get(0).getValue() == hand.get(1).getValue()) && (hand.get(3).getValue() == hand.get(4).getValue())) {
			return true;
		}
		if ((hand.get(1).getValue() == hand.get(2).getValue()) && (hand.get(3).getValue() == hand.get(4).getValue())) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the given hand is a JQKA-pair
	 * 
	 * @return true if the hand is a JQKA-pair
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */
	private boolean isJQKAPair(List<Card> hand) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getValue() == (hand.get(i + 1).getValue()) && hand.get(i).getValue() > 10) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given hand is a pair
	 * 
	 * @return true if the hand is a pair
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */
	private boolean isPair(List<Card> hand) {
		for (int i = 0; i < (hand.size() - 1); i++) {
			if (hand.get(i).getValue() == (hand.get(i + 1).getValue())) {
				return true;
			}

		}
		return false;
	}

	public boolean isFlush() {
		/**
		 * Checks if the given hand is a flush
		 * 
		 * @return true if the hand is a flush
		 * @param hand must be a sorted list of cards (assuming sorting by value)
		 */	
		
		int antalKortMedSammaFÃ¤rg = 0;
		Suit suitPåFörstaKortet = hand.get(0).getSuit();
		
		for(int i = 0; i < hand.size() -1; i++) {
			
			if(suitPåFörstaKortet == (hand.get(i).getSuit())){
				antalKortMedSammaFÃ¤rg++;
			}
			 
		}
		if (antalKortMedSammaFÃ¤rg == 5) {
			return true; 
					} else {
						return false;
					}	
	}
	/**
	 * Checks if the given hand is a Straight
	 * 
	 * @return true if the hand is a Straight
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */	
	public boolean isStraight(List<Card> hand) {

		int i = 0;
		if (hand.get(i).getValue() == hand.get(i + 1).getValue() + 1) {
			if (hand.get(i + 1).getValue() == hand.get(i + 2).getValue() + 1) {
				if (hand.get(i + 2).getValue() == hand.get(i + 3).getValue() + 1) {
					if (hand.get(i + 3).getValue() == hand.get(i + 4).getValue() + 1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Checks if the given hand is a Straight flush
	 * 
	 * @return true if the hand is a Straight flush
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */	
	public boolean isStraightFlush(List<Card> hand) {

		int i = 0;
		if (hand.get(i).getValue() == (hand.get(i + 1).getValue() + 1)
				&& hand.get(i).getSuit() == hand.get(i + 1).getSuit()) {
			if (hand.get(i + 1).getValue() == hand.get(i + 2).getValue() + 1
					&& hand.get(i + 1).getSuit() == hand.get(i + 2).getSuit()) {
				if (hand.get(i + 2).getValue() == hand.get(i + 3).getValue() + 1
						&& hand.get(i + 2).getSuit() == hand.get(i + 3).getSuit()) {
					if (hand.get(i + 3).getValue() == hand.get(i + 4).getValue() + 1
							&& hand.get(i + 3).getSuit() == hand.get(i + 4).getSuit()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Checks if the given hand is a Royal Straight Flush
	 * 
	 * @return true if the hand is a Royal Straight Flush
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */	
	public boolean isRoyalStraightFlush(List<Card> hand) {
		// FÃ¤rg och stege 10-Ess
		int i = 0;
		if (hand.get(i).getValue() == 1) {
			if (hand.get(i + 1).getValue() == 10 && hand.get(i).getSuit() == hand.get(i + 1).getSuit()) {
				if (hand.get(i + 2).getValue() == 11 && hand.get(i).getSuit() == hand.get(i + 2).getSuit()) {
					if (hand.get(i + 3).getValue() == 12 && hand.get(i).getSuit() == hand.get(i + 3).getSuit()) {
						if (hand.get(i + 4).getValue() == 13 && hand.get(i).getSuit() == hand.get(i + 4).getSuit()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
