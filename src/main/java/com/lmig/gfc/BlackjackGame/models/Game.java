package com.lmig.gfc.BlackjackGame.models;

public class Game {

	private Deck deck = new Deck();
	private Hand hand = new Hand();
	private Hand dealer = new Hand();

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

		// deal two cards to the player and the dealer from the deck
		Card card = deck.draw();
		hand.accept(card);

		card = deck.draw();
		dealer.accept(card);

		card = deck.draw();
		hand.accept(card);

		card = deck.draw();
		dealer.accept(card);
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

}
