package com.wahlbeck.advanceddota2stats.TO;

import com.google.gson.annotations.SerializedName;

public class MatchPlayersTO {
	
	@SerializedName("account_id")
	private String accountID;
	
	@SerializedName("player_slot")
	private int playerSlot;
	
	@SerializedName("hero_id")
	private int heroID;

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public int getPlayerSlot() {
		return playerSlot;
	}

	public void setPlayerSlot(int playerSlot) {
		this.playerSlot = playerSlot;
	}

	public int getHeroID() {
		return heroID;
	}

	public void setHeroID(int heroID) {
		this.heroID = heroID;
	}
	
	
}
