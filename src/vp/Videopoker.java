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
}
