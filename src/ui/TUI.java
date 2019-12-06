package ui;

import java.util.List;
import java.util.Scanner;

import vp.Card;
import vp.Videopoker;

public class TUI {

	Videopoker vp = new Videopoker();

	boolean[] selectedCards = { false, false, false, false, false };

	Scanner s;

	public TUI(Scanner s) {

		this.s = s;
	}

	public void run() {

		mainMenu();
	}

	private void mainMenu() {

		System.out.println("################\n" +
				"# Video poker! #\n" +
				"################");

		System.out.println("# Main Menu    #");
		System.out.println("# [1] New Game #");
		System.out.println("# [2] Exit     #");
		System.out.println(">> Your choice:");

		int menuChoice = s.nextInt();

		s.nextLine();

		switch (menuChoice) {
		case 1:
			gameLoop();
			break;
		case 2:
			return;
		}
	}

	private void gameLoop() {

		// while (true) {
		vp.resetGame();
		printCards(vp.getHand());
		selectCards(vp.getHand());
		printCards(vp.getHand());
		confirmHeldCards();
		// vp.holdCards(boolean[] heldCards);
		// vp.getNewCards();
		// vp.getPokerHand();
		//
		// }
	}

	private boolean confirmHeldCards() {

		System.out.println("Are you happy with your selection?\n"
				+ "[1] YES - I want to hold these cards\n"
				+ "[2] NO - I want to make a new selection");

		int menuChoice = s.nextInt();

		switch (menuChoice) {
		case 1:
			return true;
		default:
			return false;
		}
	}

	private void selectCards(List<Card> hand) {

		System.out.println("Which cards do you want to hold?:");
		String[] selection = s.nextLine().split(" ");
				
		for(String position: selection) {
			
			if(position.isEmpty()) {
				continue;
			}
			try {
				int cardIndex = Integer.parseInt(position) - 1;
				
				if (cardIndex < 0 || cardIndex > hand.size() - 1) {
					System.err.println("Could not select card " + (cardIndex + 1));
				} else {
					selectedCards[cardIndex] = true;
				}
			} catch(Exception e) {
				System.err.println("Could not select card " + position);
			}
		}
		
	}

	private void printCards(List<Card> hand) {

		StringBuilder sb = new StringBuilder();
		sb.append("Your cards:\n");

		for (int i = 0; i < hand.size(); i++) {
			sb.append("[" + (i + 1) + "]");
			sb.append(hand.get(i));
			if (isHeld(i)) {
				sb.append(" (HOLDING)");
			}
			sb.append(", ");
		}
		System.out.println(sb);
	}

	private boolean isHeld(int cardIndex) {

		return selectedCards[cardIndex];
	}

}
