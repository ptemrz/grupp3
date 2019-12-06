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
	
	public boolean isStraight(List<Card> hand) {
		
		int i = 0;
			if (hand.get(i).getValue() == hand.get(i+1).getValue() + 1) {
				if (hand.get(i+1).getValue() == hand.get(i+2).getValue() + 1) {
					if (hand.get(i+2).getValue() == hand.get(i+3).getValue() + 1) {
						if (hand.get(i+3).getValue() == hand.get(i+4).getValue() + 1){
							return true;
						}
					}
				}
			} 
			return false;
	}
			 
	
	
	public boolean isStraightFlush(List<Card> hand) {

		int i = 0;
		if (hand.get(i).getValue() == (hand.get(i+1).getValue() + 1) && hand.get(i).getSuit() == hand.get(i+1).getSuit()) {
			if (hand.get(i+1).getValue() == hand.get(i+2).getValue() + 1 && hand.get(i+1).getSuit() == hand.get(i+2).getSuit()) {
				if (hand.get(i+2).getValue() == hand.get(i+3).getValue() + 1 && hand.get(i+2).getSuit() == hand.get(i+3).getSuit()) {
					if (hand.get(i+3).getValue() == hand.get(i+4).getValue() + 1 && hand.get(i+3).getSuit() == hand.get(i+4).getSuit()){
						return true;
					}
				}
			}
		} 
		return false;
	}

	public boolean isRoyalStraightFlush(List<Card> hand) {
		//Färg och stege 10-Ess
		int i = 0;
		if (hand.get(i).getValue() == 1 
				/*|| hand.get(i).getValue() == 10 
				|| hand.get(i).getValue() == 11 
				|| hand.get(i).getValue() == 12 
				|| hand.get(i).getValue() == 13*/) {
			if (hand.get(i+1).getValue() == 10 
					/*|| hand.get(i+1).getValue() == 11
					|| hand.get(i+1).getValue() == 12
					|| hand.get(i+1).getValue() == 13*/ && hand.get(i).getSuit() == hand.get(i+1).getSuit()) {
				if (hand.get(i+2).getValue() == 11
						/*|| hand.get(i+2).getValue() == 12
						|| hand.get(i+2).getValue() == 13*/ && hand.get(i).getSuit() == hand.get(i+2).getSuit()) {
					if (hand.get(i+3).getValue() == 12
							/*|| hand.get(i+3).getValue() == 13*/ && hand.get(i).getSuit() == hand.get(i+3).getSuit()) {
						if (hand.get(i+4).getValue() == 13 && hand.get(i).getSuit() == hand.get(i+4).getSuit()) {
							return true;
						}
					}			
				}
			}
		} 
		return false;
	}
}
