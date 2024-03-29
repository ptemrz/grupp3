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
		videopoker.hand.add(new Card(8, Suit.HEARTS));
		videopoker.hand.add(new Card(5, Suit.DIAMONDS));
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(1, Suit.DIAMONDS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		val = videopoker.isPair(videopoker.hand);
		assertEquals(asume, val);
	}

	@Test
	void testIsFlush() {

		boolean asume = true;
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(5, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));

		assertEquals(asume, videopoker.isFlush(videopoker.hand));
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
	void testStraight() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(4, Suit.SPADES));
		videopoker.hand.add(new Card(5, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		val = videopoker.isStraight(videopoker.hand);
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
	@Test
	void testStraightFlush() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(4, Suit.HEARTS));
		videopoker.hand.add(new Card(5, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		val = videopoker.isStraightFlush(videopoker.hand);
		assertEquals(asume, val);
	}
	@Test
	void testThreeOfAKind() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.DIAMONDS));
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.DIAMONDS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		val = videopoker.isThreeOfAKind(videopoker.hand);
		assertEquals(asume, val);
	}

	@Test
	void testFullHouse() {
		boolean asume = true;
		boolean val;
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		val = videopoker.isFullHouse(videopoker.hand);
		assertEquals(asume, val);
	}
	@Test
	void testKortKombinationer() {
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.HEARTS));
		videopoker.hand.add(new Card(11, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		videopoker.hand.add(new Card(13, Suit.HEARTS));
		
		assertEquals(videopoker.getPokerHand(videopoker.hand), KortKombinationer.ROYALSTRAIGHTFLUSH);
	}
	
	@Test
	void testKortKombinationerOsorteradHand() {
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.HEARTS));
		videopoker.hand.add(new Card(11, Suit.HEARTS));
		videopoker.hand.add(new Card(13, Suit.HEARTS));
		videopoker.hand.add(new Card(12, Suit.HEARTS));
		
		assertEquals(videopoker.getPokerHand(videopoker.hand), KortKombinationer.ROYALSTRAIGHTFLUSH);
	}
	
	@Test
	void testsortHand() {
		videopoker.hand.add(new Card(5, Suit.HEARTS));
		videopoker.hand.add(new Card(6, Suit.HEARTS));
		videopoker.hand.add(new Card(3, Suit.HEARTS));
		videopoker.hand.add(new Card(4, Suit.HEARTS));
		videopoker.hand.add(new Card(2, Suit.HEARTS));
		boolean statement = false;
		List<Card> sortedHand = videopoker.sortHand();
		System.out.println(sortedHand);
		
		if(videopoker.isStraightFlush(sortedHand)) {
			statement = true;
		} else statement = false;
		assertEquals(true, statement);
		
	}
	@Test
	void testFourOfAKind() {
		boolean asume = true;
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.SPADES));
		videopoker.hand.add(new Card(10, Suit.DIAMONDS));
		videopoker.hand.add(new Card(10, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.CLUBS));
		
		assertEquals(asume, videopoker.isFourOfAKind(videopoker.hand));
	}
	
	@Test
	void testSortSameLength() {
		videopoker.hand.add(new Card(1, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.SPADES));
		videopoker.hand.add(new Card(10, Suit.DIAMONDS));
		videopoker.hand.add(new Card(10, Suit.HEARTS));
		videopoker.hand.add(new Card(10, Suit.CLUBS));
		List<Card> sortedHand = videopoker.sortHand();
		
		assertEquals(videopoker.hand.size(), sortedHand.size());
	}

	
//	private KortKombinationer getPokerHand(List<Card>hand) {
//		
//		if (isRoyalStraightFlush(hand) == true) {
//			return KortKombinationer.ROYALSTRAIGHTFLUSH;
//		}
}
