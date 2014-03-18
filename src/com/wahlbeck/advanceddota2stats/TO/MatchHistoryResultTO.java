package com.wahlbeck.advanceddota2stats.TO;

import com.google.gson.annotations.SerializedName;

public class MatchHistoryResultTO {
	
	private int status;
	
	@SerializedName("num_results")
	private int numberResults;
	
	@SerializedName("total_results")
	private int totalResults;
	
	@SerializedName("results_remaining")
	private int resultsRemaining;
	
	private DotaMatchesTO matches;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNum_results() {
		return numberResults;
	}

	public void setNum_results(int num_results) {
		this.numberResults = num_results;
	}

	public int getTotal_results() {
		return totalResults;
	}

	public void setTotal_results(int total_results) {
		this.totalResults = total_results;
	}

	public int getResults_remaining() {
		return resultsRemaining;
	}

	public void setResults_remaining(int results_remaining) {
		this.resultsRemaining = results_remaining;
	}

	public DotaMatchesTO getMatches() {
		return matches;
	}

	public void setMatches(DotaMatchesTO matches) {
		this.matches = matches;
	}

}
