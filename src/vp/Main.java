package vp;

import java.util.Scanner;

import ui.TUI;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Initiating Scanner");
		Scanner s = new Scanner(System.in);
		new TUI(s).run();
		s.close();

	}

}
