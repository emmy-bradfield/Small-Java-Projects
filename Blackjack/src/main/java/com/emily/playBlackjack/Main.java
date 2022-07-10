package com.emily.playBlackjack;

import java.util.Scanner;

public class Main {
	
	// =-=-=-=-=-=-=-=-=-=-= Variables =-=-=-=-=-=-=-=-=-=-=
	Integer a;
	Integer total = 0;

	// =-=-=-=-=-=-=-=-=-=-= Main Function =-=-=-=-=-=-=-=-=-=-=
	public static void main(String[] args) {
		Card card = new Card();
		Scanner scan = new Scanner(System.in);
		System.out.print("Hey, welcome to BlackJack! What's your namme?\n>> ");
		String playerOne = scan.nextLine();
		System.out.print("\nWell nice to meet you, " + playerOne + " lets get started!");
		System.out.print("\n\t\t [DEALING HAND]\n");
		card.firstCard();
		scan.close();

	}

}
