package com.emily.playBlackjack;

import java.util.Scanner;

public class Main {
	
	// =-=-=-=-=-=-=-=-=-=-= Variables =-=-=-=-=-=-=-=-=-=-=
	Integer a;
	Integer total = 0;
	static String playerOne;
  
	// =-=-=-=-=-=-=-=-=-=-= Main Function =-=-=-=-=-=-=-=-=-=-=
	public static void main(String[] args) {
		Card card = new Card();
		card.firstCard();
		card.playerTwoFirstHand();
		card.hitStand();

	}
}
