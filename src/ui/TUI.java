package ui;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import vp.Card;
import vp.KortKombinationer;
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

		boolean stayInMainMenu = true;
		while (stayInMainMenu) {

			System.out.println("################\n" +
					"# Video poker! #\n" +
					"################");

			System.out.println("# Main Menu    #");
			System.out.println("# [1] New Game #");
			System.out.println("# [2] Exit     #");
			System.out.println(">> Your choice:");

			try {
				int menuChoice = s.nextInt();

				s.nextLine();

				System.out.println("");

				switch (menuChoice) {
				case 1:
					gameLoop();
					break;
				case 2:
					stayInMainMenu = false;
					;
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
	}

	private void gameLoop() {

		while (true) {

			vp.resetGame();
			resetSelection();

			do {
				printCards(vp.getHand());
				selectCards(vp.getHand());
				printCards(vp.getHand());
			} while (!confirmHeldCards());

			printPokerHand(vp.getPokerHand(vp.getHand()));

			if (!keepPlaying()) {
				break;
			}
		}
		// vp.holdCards(boolean[] heldCards);
		// vp.getNewCards();
		// vp.getPokerHand();
		//
		// }
	}
	
	private void resetSelection() {
		for (boolean b : selectedCards) {
			b = false;
		}
	}

	private boolean keepPlaying() {

		System.out.println("Do you want to keep playing?\n" +
				"[1] Yes - play another hand\n" +
				"[2] NO - Quit the game");
		try {
			int menuChoice = s.nextInt();

			s.nextLine();

			System.out.println("");

			switch (menuChoice) {
			case 1:
				return true;
			default:
				return false;
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void printPokerHand(KortKombinationer pokerHand) {

		String hand = pokerHand.name().toLowerCase();

		if (pokerHand == KortKombinationer.PAIRJQKA) {
			hand = "royal pair";
		}

		System.out.println("You got " + hand);

	}

	private boolean confirmHeldCards() {

		if (isSelectionMade()) {

			System.out.println("Are you happy with your selection?\n"
					+ "[1] YES - I want to hold these cards\n"
					+ "[2] NO - I want to make a new selection");
		} else {
			System.out.println("No selection made\n"
					+ "Are you sure you want to change ALL your cards?\n"
					+ "[1] YES - I want to change ALL five cards\n"
					+ "[2] NO - I want to select which cards to hold");
		}

		try {

			int menuChoice = s.nextInt();

			s.nextLine();

			switch (menuChoice) {
			case 1:
				return true;
			default:
				return false;
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isSelectionMade() {

		for (boolean b : selectedCards) {
			if (b) {
				return true;
			}
		}
		return false;
	}

	private void selectCards(List<Card> hand) {

		System.out.println("Which cards do you want to hold?:");
		String[] selection = s.nextLine().split(" ");
		System.out.println();

		for (String position : selection) {

			if (position.isEmpty()) {
				continue;
			}

			try {
				int cardIndex = Integer.parseInt(position) - 1;

				if (cardIndex < 0 || cardIndex > hand.size() - 1) {
					System.err.println("\nCould not select card " + (cardIndex + 1));
					System.out.println();
				} else {
					selectedCards[cardIndex] = true;
				}
			} catch (Exception e) {
				System.err.println("Could not select card " + position);
				System.out.println();
			}
		}

	}

	private void printCards(List<Card> hand) {

		StringBuilder sb = new StringBuilder();
		sb.append("\nYour cards:\n");

		for (int i = 0; i < hand.size(); i++) {
			sb.append("[" + (i + 1) + "] ");
			sb.append(hand.get(i));
			if (isHeld(i)) {
				sb.append(" (HOLDING)");
			}
			sb.append(", ");
		}
		System.out.println(sb);
		System.out.println();
	}

	private boolean isHeld(int cardIndex) {

		return selectedCards[cardIndex];
	}

}
