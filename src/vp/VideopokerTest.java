package vp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class VideopokerTest {

	private Deck deck;
	private Card card;
	private Videopoker videopoker;

	@BeforeEach
	void newDeck() {
		deck = new Deck();
	}
	@BeforeEach
	void newVideopoker() {
		videopoker = new Videopoker();
	}
	@Test
	void testIsPair() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(1, Suit.DIAMONDS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.DIAMONDS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		val = videopoker.isPair(videopoker.hand);
		assertEquals(asume, val);
	}

}
