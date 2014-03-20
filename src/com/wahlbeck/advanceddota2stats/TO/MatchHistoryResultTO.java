package com.wahlbeck.advanceddota2stats.TO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class MatchHistoryResultTO {
	
	private int status;
	
	@SerializedName("num_results")
	private int numberResults;
	
	@SerializedName("total_results")
	private int totalResults;
	
	@SerializedName("results_remaining")
	private int resultsRemaining;
	
	private DotaMatchesTO[] matches;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getNumberResults() {
		return numberResults;
	}

	public void setNumberResults(int numberResults) {
		this.numberResults = numberResults;
	}
	
	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public int getResultsRemaining() {
		return resultsRemaining;
	}

	public void setResultsRemaining(int resultsRemaining) {
		this.resultsRemaining = resultsRemaining;
	}

	public DotaMatchesTO[] getMatches() {
		return matches;
	}
	
	public void setMatches(DotaMatchesTO[] matches) {
		this.matches = matches;
	}



	public static MatchHistoryResultTO fromJson(String json) {
		MatchHistoryResultTO retVal = null;
		GsonBuilder gb = new GsonBuilder();
		Gson g = gb.create();
		JsonParser jp = new JsonParser();
		JsonObject jo = (JsonObject) jp.parse(json);
		JsonElement j2 = jp.parse(json);
		if (jo.has("result")) {
			j2= jo.get("result");
		}
		if (j2 != null) {
			retVal = g.fromJson(j2, MatchHistoryResultTO.class);
		}
		return retVal;
	}
}
