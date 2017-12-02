package com.lmig.gfc.BlackjackGame.models;

public class Wallet {

	private double money = 100;

	public void removeFromWallet(double bet) {

		money = money - bet;

	}

	public void addtoWallet(double bet) {

		money = money + bet;

	}

	public boolean walletIsEmpty() {
		if (money <= 0) {
			return true;
		}
		return false;
	}
}
