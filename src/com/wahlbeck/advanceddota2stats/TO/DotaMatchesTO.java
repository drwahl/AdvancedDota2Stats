package com.wahlbeck.advanceddota2stats.TO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class DotaMatchesTO {

	@SerializedName("match_id")
	private String matchID;
	
	@SerializedName("match_seq_num")
	private String matchSequenceNum;
	
	@SerializedName("start_time")
	private String startTime;
	
	@SerializedName("lobbyType")
	private int lobbyType;
	
	private MatchPlayersTO[] players;

	public String getMatch_id() {
		return matchID;
	}

	public void setMatch_id(String match_id) {
		this.matchID = match_id;
	}

	public String getMatch_seq_num() {
		return matchSequenceNum;
	}

	public void setMatch_seq_num(String match_seq_num) {
		this.matchSequenceNum = match_seq_num;
	}

	public String getStart_time() {
		return startTime;
	}

	public void setStart_time(String start_time) {
		this.startTime = start_time;
	}

	public int getLobby_type() {
		return lobbyType;
	}

	public void setLobby_type(int lobby_type) {
		this.lobbyType = lobby_type;
	}

	public MatchPlayersTO[] getPlayers() {
		return players;
	}

	public void setPlayers(MatchPlayersTO[] players) {
		this.players = players;
	}
	
	
	public DotaMatchesTO fromJSON(String json) {
		Gson g = new Gson();
				
		return null;
		
	}
	
}
