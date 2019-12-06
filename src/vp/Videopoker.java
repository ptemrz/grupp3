package vp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Videopoker {

	Deck deck = new Deck();

	List<Card> hand = new ArrayList<>();
	
	public void keepTheseCards() {
		
		
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();
		String e = "exit";
		while(!i.equals(e)) {
			if(hand.size() == 0) {
				i = "exit";
			}
			if(i.equals("1")) {
				hand.remove(0);
				i = sc.nextLine();
			}
			else if(i.equals("2")) {
				hand.remove(1);
				i = sc.nextLine();
			}
			else if(i.equals("3")) {
				hand.remove(2);
				i = sc.nextLine();
			}
			else if(i.equals("4")) {
				hand.remove(3);
				i = sc.nextLine();
			}
			else if(i.equals("5")) {
				hand.remove(4);
				i = sc.nextLine();
			}
		}
		
		
	}
	
	public void fillHandWithCards() {
		while(hand.size() < 5) {
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
	
	private boolean isFourOfAKind(List<Card> hand) {
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
		
		for(int i = 0; i < hand.size(); i++) {
			
			if(sameSuit == (hand.get(i).getSuit())){
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
		if (hand.get(i).getValue() + 1 == (hand.get(i + 1).getValue()) && hand.get(i).getSuit() == hand.get(i + 1).getSuit()) {
			if (hand.get(i + 1).getValue() + 1 == hand.get(i + 2).getValue() && hand.get(i + 1).getSuit() == hand.get(i + 2).getSuit()) {
				if (hand.get(i + 2).getValue() + 1 == hand.get(i + 3).getValue() && hand.get(i + 2).getSuit() == hand.get(i + 3).getSuit()) {
					if (hand.get(i + 3).getValue() + 1 == hand.get(i + 4).getValue() && hand.get(i + 3).getSuit() == hand.get(i + 4).getSuit()) {
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
	
	/**
	 * Checks if the given hand matches any combinations
	 * 
	 * @return corresponding value from kortkombinationer
	 * @param hand - the list of face-up cards
	 */	
	public KortKombinationer getPokerHand(List<Card>hand) {
		
		if (isRoyalStraightFlush(hand)) {
			return KortKombinationer.ROYALSTRAIGHTFLUSH;
		}
		else if (isStraightFlush(hand)) {
			return KortKombinationer.STRAIGHTFLUSH;
		}
		else if (isFourOfAKind(hand)) {
			return KortKombinationer.FOUROFAKIND;
		}
		else if (isFullHouse(hand)) {
			return KortKombinationer.FULLHOUSE;
		}
		else if (isFlush(hand)) {
			return KortKombinationer.FLUSH;
		}
		else if (isStraight(hand)) {
			return KortKombinationer.STRAIGHT;
		}
		else if (isThreeOfAKind(hand)) {
			return KortKombinationer.THREEOFAKIND;
		}
		else if (isTwoPair(hand)) {
			return KortKombinationer.TWOPAIRS;
		}
		else if (isJQKAPair(hand)) {
			return KortKombinationer.PAIRJQKA;
		}
		else if (isPair(hand)) {
			return KortKombinationer.PAIR;
		}
		else {
			return KortKombinationer.EMPTY;
		}
	}
}
