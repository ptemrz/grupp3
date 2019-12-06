package ui;

import java.util.Scanner;

import vp.Videopoker;

public class TUI {
	
	Videopoker vp = new Videopoker();
	Scanner s;
	
	public TUI(Scanner s) {
		this.s = s;
	}
	
	public void run() {
		mainMenu();		
	}
	
	private void mainMenu() {
		
		System.out.println("################\n"+
				           "# Video poker! #\n"+
				           "################");
		
		System.out.println("# Main Menu    #");
		System.out.println("# [1] New Game #");
		System.out.println("# [2] Exit     #");
		System.out.println(">> Your choice:");
		
		int menuChoice = s.nextInt();
		
		switch (menuChoice) {
		case 1: gameLoop(); break;
		case 2: return;
		}
	}	
	
	private void gameLoop() {
		//while (true) {
			vp.resetGame();
			//printCards(vp.getCards());
			//selectCards();
			//confirmHeldCards();
			//vp.holdCards(boolean[] heldCards);
			//vp.getNewCards();
			//vp.getPokerHand();
			//
		//}
	}
	
}
