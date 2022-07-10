package com.emily.playBlackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Card {
	// =-=-=-=-=-=-=-=-=-=-= Attributes =-=-=-=-=-=-=-=-=-=-=
	Integer cardValue;
	Integer HandOne = 0;
	Integer currentCard;

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
	
	// =-=-=-=-=-=-=-=-=-=-= Methods =-=-=-=-=-=-=-=-=-=-=

	public int handOneScore() { /* calculate the current value of player one's hand */
		HandOne = HandOne + getCard();
		return HandOne;
	}
	
	public void firstCard() { /* drawn a card using RNG, then calculate and print hand value */
		int a = 0;
		int loop = ThreadLocalRandom.current().nextInt(2);
		if (loop == 0) {
			a = ThreadLocalRandom.current().nextInt(2, 11);
			System.out.print("\t\t  You drew ... " + a + "\n");
			setCard(a);
		} else if (loop == 1) {
			a = ThreadLocalRandom.current().nextInt(10, 14);
			if (a == 13) {
				System.out.print("\t\tYou drew ... King\n");
				setCard(10);
			} else if (a == 12) {
				System.out.print("\t\tYou drew ... Queen\n");
				setCard(10);
			} else if (a == 11) {
				System.out.println("\t\tYou drew ... Jack\n");
				setCard(10);
			} else if (a == 10) {
				System.out.print("\t\tYou drew ... Ace\n");
				setCard(1);
			}
		}
		handOneScore();
		a = 0;
		loop = ThreadLocalRandom.current().nextInt(2);
		if (loop == 0) {
			a = ThreadLocalRandom.current().nextInt(2, 11);
			setCard(a);
			System.out.print("\t\t  You drew ... " + a + "\n");
		} else if (loop == 1) {
			a = ThreadLocalRandom.current().nextInt(10, 14);
			if (a == 13) {
				System.out.print("\t\tYou drew ... King\n");
				setCard(10);
			} else if (a == 12) {
				System.out.print("\t\tYou drew ... Queen\n");
				setCard(10);
			} else if (a == 11) {
				System.out.println("\t\tYou drew ... Jack\n");
				setCard(10);
			} else if (a == 10) {
				System.out.print("\t\tYou drew ... Ace\n");
				setCard(1);
			}
		}
		handOneScore();
		System.out.print("\t\t\t\t(Total: " + HandOne + ")");
	}

}
