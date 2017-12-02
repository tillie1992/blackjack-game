package com.lmig.gfc.BlackjackGame.models;

public class Game {

	private Deck deck = new Deck();
	private Hand hand = new Hand();
	private Hand dealer = new Hand();
	private Wallet wallet = new Wallet();
	private int betForHand;

	public void hitPlayer() {
		Card card = deck.draw();
		hand.accept(card);
	}

	public void hitDealer() {
		while (dealer.getTotal() < 17) {
			Card card = deck.draw();
			dealer.accept(card);
		}
	}

	public Game() {
		deck.shuffle();
	}

	public void deal() {
		hand = new Hand();
		dealer = new Hand();

		Card card = deck.draw();
		hand.accept(card);

		card = deck.draw();
		dealer.accept(card);

		card = deck.draw();
		hand.accept(card);

		card = deck.draw();
		dealer.accept(card);
	}

	public boolean playerHasBackjack() {
		if (hand.numberOfCardsInHand() == 2 && hand.getTotal() == 21) {
			return true;
		}
		return false;
	}

	public boolean isTie() {
		if (hand.getTotal() == dealer.getTotal()) {
			return true;
		}
		return false;
	}

	public boolean isHandOver() {
		if (hand.getTotal() == 21) {
			return true;
		}
		return false;
	}

	public boolean playerHasMoreThan21() {
		if (hand.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean dealerHasMoreThan21() {
		if (dealer.getTotal() > 21) {
			return true;
		}
		return false;
	}

	public boolean deckIsEmpty() {
		if (deck.getCardsInDeck().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean hasMoreThanFiveCards() {
		if (deck.size() > 5) {
			return true;
		}
		return false;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void placeBet(int bet) {
		wallet.removeFromWallet(bet);
		betForHand = bet;
	}

	public void calculatePayOut() {
		// If player and dealer is blackjack
		if (hand.isBlackjack() && dealer.isBlackjack()) {
			wallet.addtoWallet(betForHand);
		}
		else if(!dealer.isBlackjack()&& hand.isBlackjack()) {
			wallet.addtoWallet(betForHand *2.5);
			
		}
		// Simple win where the player is not busted and has more than dealer
		else if (hand.getTotal() <= 21 && dealer.getTotal() < hand.getTotal()) {
			wallet.addtoWallet(betForHand * 2);
		}
		// Simple win where dealer is busted
		else if((hand.getTotal() <= 21 && dealer.getTotal() > 21)) {
			wallet.addtoWallet(betForHand * 2);
		}
		else if(hand.getTotal()<dealer.getTotal()&& dealer.getTotal()<=21) {
			wallet.removeFromWallet(betForHand);
		}
		else if(hand.getTotal()==dealer.getTotal()) {
			wallet.removeFromWallet(betForHand);
		}
		}
	}


