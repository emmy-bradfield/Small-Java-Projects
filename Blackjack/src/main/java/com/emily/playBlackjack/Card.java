package com.emily.playBlackjack;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Card {
	// =-=-=-=-=-=-=-=-=-=-= Attributes =-=-=-=-=-=-=-=-=-=-=
	String name;
	Integer cardValue;
	Boolean playerOne = true;
	Integer HandOne = 0;
	Integer HandTwo = 0;
	Integer PlayerOneHand = 0;
	Integer PlayerTwoHand = 0;
	Integer currentCard;
	Boolean OneHasAce = false;
	Boolean TwoHasAce = false;
	Integer HandOneAce;
	Integer HandTwoAce;
	Boolean OneStand = false;
	Boolean TwoStand = false;
	Integer hitOrStand;

	// =-=-=-=-=-=-=-=-=-=-= Class Constructor =-=-=-=-=-=-=-=-=-=-=
	public Card() { /* default constructor */
	};

	// =-=-=-=-=-=-=-=-=-=-= Getters and Setters =-=-=-=-=-=-=-=-=-=-=
	public int getCard() { /* get value of drawn card */
		return cardValue;
	}

	public void setCard(int cardValue) { /* set value of drawn card */
		this.cardValue = cardValue;
	}

	public boolean getOneAce() { /* get if player one has an Ace */
		return OneHasAce;
	}

	public void setOneAce(boolean OneHasAce) { /* set if player one has an Ace */
		this.OneHasAce = OneHasAce;
	}

	public boolean getTwoAce() { /* get if player two has an Ace */
		return TwoHasAce;
	}

	public void setTwoAce(boolean TwoHasAce) { /* set if player two has an Ace */
		this.TwoHasAce = TwoHasAce;
	}

	// =-=-=-=-=-=-=-=-=-=-= Methods =-=-=-=-=-=-=-=-=-=-=

	public int handOneScore() { /* calculate the current value of player one's hand */
		HandOne = HandOne + getCard();
		return HandOne;
	}

	public int handOneAce() { /* calculate the value of player one's hand if Ace is 11 */
		HandOneAce = HandOne + getCard() + 11;
		return HandOneAce;
	}

	public int handTwoScore() { /* calculate the value of player two's hand */
		HandTwo = HandTwo + getCard();
		return HandTwo;
	}

	public int handTwoAce() { /* calculate the value of player two's hand if Ace is 11 */
		HandTwoAce = HandTwo + getCard() + 11;
		return HandTwoAce;
	}

	public void firstCard() { /* draw a card using RNG, state if it is an Ace, tell a new function to calculate the hand value */
		Scanner scan = new Scanner(System.in);
		System.out.print("Hey, welcome to BlackJack! What's your name?\n>> ");
		name = scan.nextLine();
		System.out.print("\nWell nice to meet you, " + name + " lets get started!");
		System.out.print("\n\t\t [DEALING HAND]\n");
		setOneAce(false);
		for (int i = 0; i < 2; i++) {
			int a = 0;
			a = ThreadLocalRandom.current().nextInt(2, 15);
			if (a < 11) {
				System.out.print("\t\t  You drew ... " + a + "\n");
				setCard(a);
			} else if (a < 12) {
				System.out.print("\t\tYou drew ... Jack\n");
				setCard(10);
			} else if (a < 13) {
				System.out.print("\t\tYou drew ... Queen\n");
				setCard(10);
			} else if (a < 14) {
				System.out.print("\t\tYou drew ... King\n");
				setCard(10);
			} else if (a < 15) {
				System.out.print("\t\t You drew ... Ace\n");
				setCard(1);
				setOneAce(true);
			}
			getOneAce();
			if (OneHasAce == false) {
				handOneScore();
			} else if (OneHasAce == true) {
				handOneAce();
				handOneScore();
			}
		}
		if (OneHasAce == false) {
			System.out.print("\t\t\t\t(Total: " + HandOne + ")");
		} else if (OneHasAce == true) {
			System.out.print("\t\t\t\t(Total: " + HandOne + " or " + HandOneAce + ")");
		}
		
	}

	public void playerTwoFirstHand() { /* use RNG to assign player two a random hand, check for Ace's, and calculate value */
		System.out.println("\nDealing opponents hand..."); 
		setTwoAce(false);
		int b = 0;
		b = ThreadLocalRandom.current().nextInt(1, 11);
		setCard(b);
		if (b == 1) {
			setTwoAce(true);
			handTwoScore();
			handTwoAce();
		} else {
			handTwoScore();
		}
		b = 0;
		b = ThreadLocalRandom.current().nextInt(1, 12);
		setCard(b);
		if (b == 1) {
			setTwoAce(true);
			handTwoScore();
			handTwoAce();
		} else {
			handTwoScore();
		}
		System.out.println("\nOpponent's hand dealt...");
	}

	public void dealtHand() { /* calculate the current hand value and an alternate value if the hand contains an Ace */
		getOneAce();
		handOneScore();
		if (OneHasAce = false) {
			System.out.print("\t\t\t\t(Total: " + HandOne + ")");
		} else if (OneHasAce = true) {
			handOneAce();
			System.out.print("\t\t\t\t(Total: " + HandOne + " or " + HandOneAce + ")");
		}
	}

	public void hitStand() { /* method for determining if players want to hit or stand */
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\t\t [CARDS DEALT]\n" + name + "'s turn begins");
		System.out.print("\nDo you want to hit or stand? Type '1' to hit or\n'2' to stand\n>> ");
		hitOrStand = scan.nextInt();
		scan.nextLine();
		if (hitOrStand == 2) {
			PlayerOneHand = HandOne;
			PlayerTwoHand = HandTwo;
			System.out.print("\n\t\t[" + name.toString().toUpperCase() + " STANDS]\nComputer's turn begins");
			opponentCard();
		} else if (hitOrStand == 1) {
			System.out.print("\n[" + name.toString().toUpperCase() + " HITS]");
			int a = 0;
			a = ThreadLocalRandom.current().nextInt(2, 15);
			if (a < 11) {
				System.out.print("\t\t  You drew ... " + a + "\n");
				setCard(a);
			} else if (a < 12) {
				System.out.print("\t\tYou drew ... Jack\n");
				setCard(10);
			} else if (a < 13) {
				System.out.print("\t\tYou drew ... Queen\n");
				setCard(10);
			} else if (a < 14) {
				System.out.print("\t\tYou drew ... King\n");
				setCard(10);
			} else if (a < 15) {
				System.out.print("\t\t You drew ... Ace\n");
				setCard(1);
				setOneAce(true);
			}
			dealtHand();
			if (HandOne > 21) {
				PlayerOneHand = HandOne;
				PlayerTwoHand = HandTwo;
				System.out.print("\n" + name + "'s hand exceeds 21: Computer Wins!");
				System.out.print("\t\t\n" + name + ": " + PlayerOneHand);
				System.out.print("\t\t\n Computer: " + PlayerTwoHand);
			} else {
				hitStand();
			}
		}
		scan.close();
	}
	
	public Boolean whoDrew() { /* method for working out who drew the card and which total to change */
		if (playerOne == true) {
			hitStand();
			playerOne = false;
			if (OneHasAce = false) {
				System.out.print("\t\t\t\t(Total: " + HandOne + ")");
			} else {
				System.out.print("\t\t\t\t(Total: " + HandOne + " or " + HandOneAce + ")");
			}
		} else {
			opponentCard();
			playerOne = true;
			System.out.print("\n\nOpponent's turn complete, starting your turn!\n");
		}
		return playerOne;
	}
	
	public void drawCard() {  /* method to draw a card for player one if they hit */
		
	}
		
	public void opponentCard() { /* method to determine if computer hits and if so what card */
		if (HandTwo > 17) {
			System.out.print("\n[COMPUTER STANDS]\nEnding game");
			PlayerOneHand = HandOne;
			PlayerTwoHand = HandTwo;
			TwoStand = true;
		} else {
			System.out.println("\n\t\t[COMPUTER HITS]"); 
			setTwoAce(false);
			int b = 0;
			b = ThreadLocalRandom.current().nextInt(1, 11);
			setCard(b);
			if (b == 1) {
				setTwoAce(true);
				handTwoScore();
				handTwoAce();
			} else {
				handTwoScore();
			}
			if (HandTwo > 21) {
				PlayerOneHand = HandOne;
				PlayerTwoHand = HandTwo;
				System.out.print("\nComputers's hand exceeds 21: " + name + "Wins!");
				System.out.print("\n\t\t" + name + ": " + PlayerOneHand);
				System.out.print("\n\t\tComputer: " + PlayerTwoHand);
			} else if (HandTwo > 17) {
				System.out.print("\\n[COMPUTER STANDS]\\nEnding game");
				PlayerOneHand = HandOne;
				PlayerTwoHand = HandTwo;
				TwoStand = true;
			} else {
				opponentCard();
			}
		}
	}
	
}
