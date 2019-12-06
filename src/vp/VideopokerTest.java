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
	void test() {
		fail("Not yet implemented");
	}

}
