package vp;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Videopoker {

	Deck deck = new Deck();

	List<Card> hand = new ArrayList<>();

	public void holdCards(boolean[] selectedCards) {

		Card[] toRemove = new Card[5];

		for (int i = 0; i < selectedCards.length; i++) {
			if (!selectedCards[i]) {
				toRemove[i] = hand.get(i);
			}
		}

		for (Card card : toRemove) {
			hand.remove(card);
		}

	}

	/**
	 * Draw cards from the deck until there are five cards in the hand.
	 */
	public void fillHandWithCards() {

		while (hand.size() < 5) {
			hand.add(deck.draw());
		}
	}

	public void resetGame() {

		deck.shuffle();
		hand.clear();
		while (hand.size() < 5) {
			hand.add(deck.draw());
		}
	}

	public List<Card> getHand() {

		return hand;
	}

	/**
	 * Checks if the given hand is a full house
	 * 
	 * @return true if the hand is a full house
	 * @param hand must be a sorted list of cards
	 */
	public boolean isFullHouse(List<Card> hand) {

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

	public boolean isFourOfAKind(List<Card> hand) {

		if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == hand.get(2).getValue()
				&& hand.get(0).getValue() == hand.get(3).getValue()) {
			return true;
		}

		if (hand.get(1).getValue() == hand.get(2).getValue() && hand.get(1).getValue() == hand.get(3).getValue()
				&& hand.get(1).getValue() == hand.get(4).getValue()) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if the given hand is a three of a kind
	 * 
	 * @return true if the hand is a three of a kind
	 * @param hand must be a sorted list of cards (assuming sorting by value)
	 */
	public boolean isThreeOfAKind(List<Card> hand) {

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
	public boolean isTwoPair(List<Card> hand) {

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
	public boolean isJQKAPair(List<Card> hand) {

		for (int i = 0; i < (hand.size() - 1); i++) {
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
	public boolean isPair(List<Card> hand) {

		for (int i = 0; i < (hand.size() - 1); i++) {
			if (hand.get(i).getValue() == (hand.get(i + 1).getValue())) {
				return true;
			}

		}
		return false;
	}

	public boolean isFlush(List<Card> hand) {
		/**
		 * Checks if the given hand is a flush
		 * 
		 * @return true if the hand is a flush
		 * @param hand must be a sorted list of cards (assuming sorting by value)
		 */

		int cardsWithSameColor = 0;
		Suit sameSuit = hand.get(0).getSuit();

		for (int i = 0; i < hand.size(); i++) {

			if (sameSuit == (hand.get(i).getSuit())) {
				cardsWithSameColor++;
			}

		}
		if (cardsWithSameColor == 5) {
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

		if (hand.get(i).getValue() + 1 == hand.get(i + 1).getValue()) {
			if (hand.get(i + 1).getValue() + 1 == hand.get(i + 2).getValue()) {
				if (hand.get(i + 2).getValue() + 1 == hand.get(i + 3).getValue()) {
					if (hand.get(i + 3).getValue() + 1 == hand.get(i + 4).getValue()) {
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
		if (hand.get(i).getValue() + 1 == (hand.get(i + 1).getValue())
				&& hand.get(i).getSuit() == hand.get(i + 1).getSuit()) {
			if (hand.get(i + 1).getValue() + 1 == hand.get(i + 2).getValue()
					&& hand.get(i + 1).getSuit() == hand.get(i + 2).getSuit()) {
				if (hand.get(i + 2).getValue() + 1 == hand.get(i + 3).getValue()
						&& hand.get(i + 2).getSuit() == hand.get(i + 3).getSuit()) {
					if (hand.get(i + 3).getValue() + 1 == hand.get(i + 4).getValue()
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

		// Färg och stege 10-Ess
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

	public List<Card> sortHand() {

		List<Card> sortedHand = new ArrayList<Card>();

		sortedHand.add(new Card(hand.get(0).getValue(), hand.get(0).getSuit()));

		for (int i = 1; i < hand.size(); i++) {
			int j = 0;
			while (j < sortedHand.size()) {
				if (hand.get(i).getValue() < sortedHand.get(j).getValue()) {
					sortedHand.add(j, new Card(hand.get(i).getValue(), hand.get(i).getSuit()));
					break;


				} else if (j == sortedHand.size() - 1) {
					sortedHand.add(new Card(hand.get(i).getValue(), hand.get(i).getSuit()));
					break;
				}

				j++;
				
			}
		}

		return sortedHand;
	}

	/**
	 * Checks if the given hand matches any combinations
	 * 
	 * @return corresponding value from kortkombinationer
	 * @param hand - the list of face-up cards
	 */
	public KortKombinationer getPokerHand(List<Card> hand) {

		List<Card> sortedHand = sortHand();

		if (isRoyalStraightFlush(sortedHand)) {
			return KortKombinationer.ROYALSTRAIGHTFLUSH;
		} else if (isStraightFlush(sortedHand)) {
			return KortKombinationer.STRAIGHTFLUSH;
		} else if (isFourOfAKind(sortedHand)) {
			return KortKombinationer.FOUROFAKIND;
		} else if (isFullHouse(sortedHand)) {
			return KortKombinationer.FULLHOUSE;
		} else if (isFlush(sortedHand)) {
			return KortKombinationer.FLUSH;
		} else if (isStraight(sortedHand)) {
			return KortKombinationer.STRAIGHT;
		} else if (isThreeOfAKind(sortedHand)) {
			return KortKombinationer.THREEOFAKIND;
		} else if (isTwoPair(sortedHand)) {
			return KortKombinationer.TWOPAIRS;
		} else if (isJQKAPair(sortedHand)) {
			return KortKombinationer.PAIRJQKA;
		} else if (isPair(sortedHand)) {
			return KortKombinationer.PAIR;
		} else {
			return KortKombinationer.EMPTY;
		}
	}
}
