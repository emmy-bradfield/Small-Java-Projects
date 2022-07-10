package com.emily.playBlackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Card {
	// =-=-=-=-=-=-=-=-=-=-= Attributes =-=-=-=-=-=-=-=-=-=-=
	Integer cardValue;
	Integer HandOne = 0;
	Integer currentCard;
	Boolean HasAce = false;
	Integer HandOneAce;

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
	
	public boolean getAce() { /* get if drawn card is an Ace */
		return HasAce;
	}

	public void setAce(boolean HasAce) { /* set if drawn card is an Ace */
		this.HasAce = HasAce;
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
	
	public void firstCard() { /* draw a card using RNG, state if it is an Ace, tell a new function to calculate the hand value */
		setAce(false);
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
				setAce(true);
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
				setAce(true);
			}
		}
		dealtHand();
	}
	
	public void dealtHand() { /* calculate the current hand value and an alternate value if the hand contains an Ace */
		getAce();
		handOneScore();
		if (HasAce = false) {
			System.out.print("\t\t\t\t(Total: " + HandOne + ")");
		} else if (HasAce = true) {
			handOneAce();
			System.out.print("\t\t\t\t(Total: " + HandOne + " or " + HandOneAce + ")");
		}
	}

}
