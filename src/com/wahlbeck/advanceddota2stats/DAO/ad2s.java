package com.wahlbeck.advanceddota2stats.DAO;

import com.google.gson.Gson;
import com.wahlbeck.advanceddota2stats.TO.MatchHistoryResultTO;
import com.wahlbeck.advanceddota2stats.config.ConfigModel;

public class ad2s {

	public static void main(String[] args) throws Exception {
		
		String accountId = "0:42440556";
		
		Scraper d2scraper = new Scraper();
		String jsonResult = d2scraper.getMatchHistory(ConfigModel.getStringValue(ConfigModel.KEY_DOTA2_APIKEY), accountId); /*returns match history data*/
		
		MatchHistoryResultTO matchResult = MatchHistoryResultTO.fromJson(jsonResult);
		Gson g = new Gson();
		System.out.println(g.toJson(matchResult.getMatches()));
		
		
		dbdriver dbdriver = new dbdriver();
		dbdriver.updatedb(); /*update db with data from getMatchHistory*/
	}

}
