package com.emily.playBlackjack;

public class Main {
	
	// =-=-=-=-=-=-=-=-=-=-= Variables =-=-=-=-=-=-=-=-=-=-=
	Integer a;
	Integer b;
	Integer total = 0;
  
	// =-=-=-=-=-=-=-=-=-=-= Main Function =-=-=-=-=-=-=-=-=-=-=
	public static void main(String[] args) {
		Game blackjack = new Game();
		blackjack.dealCards();
		blackjack.playerTurn();

	}
}
