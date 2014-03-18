package com.wahlbeck.advanceddota2stats.TO;

import com.google.gson.annotations.SerializedName;

public class MatchPlayersTO {
	
	@SerializedName("account_id")
	String accountID;
	
	@SerializedName("player_slot")
	int playerSlot;
	
	@SerializedName("hero_id")
	int heroID;

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
