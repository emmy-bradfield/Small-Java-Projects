package com.emily.playBlackjack;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

	Scanner scan = new Scanner(System.in);

	Integer cardValue;
	String name;
	Integer HoS;
	Integer PlayerScore = 0;
	Integer PlayerScoreMax;
	Integer ComputerScore = 0;
	Integer ComputerScoreMax;
	Integer playerAce = 0;
	Integer compAce = 0;
	Integer PlayerHand;
	Integer ComputerHand;

	public int dealCards() {
		System.out.print("Hey, welcome to BlackJack! What's your name?\n>> ");
		name = scan.nextLine();
		System.out.print("\nWell nice to meet you, " + name + " lets get started!");
		System.out.print("\n\t\t [DEALING HAND]\n");
		int a = 0;
		for (int i = 0; i < 2; i++) {
			a = ThreadLocalRandom.current().nextInt(2, 15);
			if (a < 11) {
				System.out.print("\t\t  You drew ... " + a + "\n");
				cardValue = a;
			} else if (a < 12) {
				System.out.print("\t\tYou drew ... Jack\n");
				cardValue = 10;
			} else if (a < 13) {
				System.out.print("\t\tYou drew ... Queen\n");
				cardValue = 10;
			} else if (a < 14) {
				System.out.print("\t\tYou drew ... King\n");
				cardValue = 10;
			} else if (a < 15) {
				System.out.print("\t\t You drew ... Ace\n");
				cardValue = 1;
				playerAce += 1;
			}
			playerScore();
		}
		printPlayerScore();

		System.out.println("\nDealing opponents hand...");
		for (int j = 0; j < 2; j++) {
			int b = 0;
			b = ThreadLocalRandom.current().nextInt(1, 11);
			cardValue = b;
			if (b == 1) {
				compAce = +1;
			}
			computerScore();
		}
		System.out.println("\nOpponent's hand dealt...");
		return PlayerScore & PlayerScoreMax & ComputerScore & ComputerScoreMax;

	}

	public int playerTurn() {
		System.out.print("\n\t\t [CARDS DEALT]\n" + name + "'s turn begins");
		System.out.print("\nDo you want to hit or stand? Type '1' to hit or\n'2' to stand\n>> ");
		HoS = scan.nextInt();
		System.out.print("Input recieved");
		if (HoS == 2) {
			playerScore();
			System.out.print("\n\t\t[" + name.toUpperCase() + " STANDS]\nComputer's turn begins");
			if (PlayerScoreMax < 22) {
				PlayerHand = PlayerScoreMax;
			} else {
				PlayerHand = PlayerScore;
			}
			setPlayerHand(PlayerHand);
			computerTurn();
		} else if (HoS == 1) {
			System.out.print("\n\t\t[" + name.toUpperCase() + " HITS]\n");
			int a = 0;
			a = ThreadLocalRandom.current().nextInt(2, 15);
			if (a < 11) {
				System.out.print("\t\t  You drew ... " + a + "\n");
				cardValue = a;
			} else if (a < 12) {
				System.out.print("\t\tYou drew ... Jack\n");
				cardValue = 10;
			} else if (a < 13) {
				System.out.print("\t\tYou drew ... Queen\n");
				cardValue = 10;
			} else if (a < 14) {
				System.out.print("\t\tYou drew ... King\n");
				cardValue = 10;
			} else if (a < 15) {
				System.out.print("\t\t You drew ... Ace\n");
				cardValue = 1;
				playerAce += 1;
			}
			playerScore();
			printPlayerScore();
			if (PlayerScore < 22) {
				playerTurn();
			} else {
				System.out.print("\n" + name + "'s hand exceeds 21: Computer Wins!");
				System.out.print("\t\t\n" + name + ": " + PlayerScore);
				System.out.print("\t\t\n Computer: " + ComputerScore);
			}
		} else {
			System.out.println("Input not accepted, please try again");
			playerTurn();
		}
		if (PlayerScoreMax < 22) {
			PlayerHand = PlayerScoreMax;
		} else {
			PlayerHand = PlayerScore;
		}

		setPlayerHand(PlayerHand);
		return PlayerHand;

	}

	public int computerTurn() {
		if (ComputerScore > 16) {
			System.out.print("\n\t\t[COMPUTER STANDS]\nEnding game");
			computerScore();
			if (ComputerScoreMax < 22) {
				ComputerHand = ComputerScoreMax;
			} else {
				ComputerHand = ComputerScore;
			}
			setComputerHand(ComputerHand);
			finalScores();
		} else {
			System.out.print("\n\t\t[COMPUTER HITS]\n");
			int b = 0;
			b = ThreadLocalRandom.current().nextInt(1, 11);
			cardValue = b;
			if (b == 1) {
				compAce += 1;
			}
			computerScore();
		}
		if (ComputerScore > 21) {
			System.out.print("\nComputer's hand exceeds 21: " + name + " Wins!");
			System.out.print("\t\t\n" + name + ": " + PlayerHand);
			System.out.print("\t\t\n Computer: " + ComputerHand);
		} else if (ComputerScore > 16) {
			System.out.print("\n\t\t[COMPUTER STANDS]\nEnding game");
			computerScore();
			if (ComputerScoreMax < 22) {
				ComputerHand = ComputerScoreMax;
			} else {
				ComputerHand = ComputerScore;
			}
			setComputerHand(ComputerHand);
			finalScores();
		} else {
			computerTurn();
		}
		if (ComputerScoreMax < 22) {
			ComputerHand = ComputerScoreMax;
		} else {
			ComputerHand = ComputerScore;
		}
		setComputerHand(ComputerHand);
		return ComputerHand;
	}

	public void finalScores() {
		getComputerHand();
		getPlayerHand();
		System.out.print("\n\t\t[FINAL SCORES]\n");
		System.out.print("\n" + name + " score: \t\t\t" + PlayerHand + "\n");
		System.out.print("\nComputer score: \t\t" + ComputerHand + "\n");
		if (PlayerHand > ComputerHand) {
			System.out.print("\n\n\t\t" + name.toUpperCase() + " WINS!!!");
		} else if (ComputerHand > PlayerHand) {
			System.out.print("\n\n\t\tCOMPUTER WINS!!!");
		} else {
			System.out.print("\n\n\t\t\tIT'S A DRAW!!!");
		}
	}

	public int playerScore() {
		PlayerScore = PlayerScore + cardValue;
		PlayerScoreMax = PlayerScore + (11 * playerAce);
		return PlayerScore & PlayerScoreMax;
	}

	public void printPlayerScore() {
		if (PlayerScore == PlayerScoreMax) {
			System.out.print("\n\t\t\t\t(Total: " + PlayerScore + ")\n");
		} else {
			System.out.print("\n\t\t\t\t(Total: " + PlayerScore + "/" + PlayerScoreMax + ")\n");
		}
	}

	public int computerScore() {
		ComputerScore = ComputerScore + cardValue;
		ComputerScoreMax = ComputerScore + (11 * compAce);
		return ComputerScore & ComputerScoreMax;
	}

	// =-=-=-=-=-=-=-=-=-=-= Class Constructor =-=-=-=-=-=-=-=-=-=-=
	public Game() {
	};

	public void setComputerHand(int ComputerHand) {
		this.ComputerHand = ComputerHand;
	}

	public void setPlayerHand(int PlayerHand) {
		this.PlayerHand = PlayerHand;
	}

	public int getComputerHand() {
		return ComputerHand;
	}

	public int getPlayerHand() {
		return PlayerHand;
	}
}
