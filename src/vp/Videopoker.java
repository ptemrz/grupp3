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

	// Metoden letar efter par, förutsätter att handen är sorterad
	private boolean isPair(List<Card> hand) {
		for (int i = 0; i < (hand.size() - 1); i++) {
			if (hand.get(i) == hand.get(i + 1)) {
				return true;
			}

		}
		return false;
	}
}
