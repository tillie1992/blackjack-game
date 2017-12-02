package com.lmig.gfc.BlackjackGame.models;

import java.util.ArrayList;

import java.util.Collections;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {

		cardsInDeck = new ArrayList<Card>();

		for (Suits suit : Suits.values()) {
			AceCard aceCard;
			aceCard = new AceCard(suit);
			cardsInDeck.add(aceCard);

			for (Faces faces : Faces.values()) {
				FaceCard faceCard;
				faceCard = new FaceCard(suit, faces);
				cardsInDeck.add(faceCard);
			}
			for (int i = 2; i <= 10; i = i + 1) {
				NumberCard numberCard;
				numberCard = new NumberCard(suit, i);
				cardsInDeck.add(numberCard);
			}
		}
	}

	public ArrayList<Card> getCardsInDeck() {
		return cardsInDeck;
	}

	public int size() {
		return cardsInDeck.size();
	}

	public Card draw() {
		Card card = cardsInDeck.remove(0);
		return card;
	}

	public void shuffle() {
		Collections.shuffle(cardsInDeck);

	}

}
