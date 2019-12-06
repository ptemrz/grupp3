package vp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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


	@Test
	void testIsFlush() {
	
		boolean ärDetFärg = true;
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(5, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		
		assertEquals(ärDetFärg, videopoker.isFlush(videopoker.hand));
	}
		
	@Test
	void testIsJQKAPair() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.DIAMONDS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.DIAMONDS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		val = videopoker.isJQKAPair(videopoker.hand);
		assertEquals(asume, val);
	}
	@Test
	void testDoublePair() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.DIAMONDS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.DIAMONDS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		val = videopoker.isTwoPair(videopoker.hand);
		assertEquals(asume, val);
	}
	@Test
	void testRoyalStraightFlush() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.HEARTS));
		videopoker.hand.add(new Card(11, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(13, Suit.HEARTS));
		val = videopoker.isRoyalStraightFlush(videopoker.hand);
		assertEquals(asume, val);

	}
}
