package com.wahlbeck.advanceddota2stats.DAO;

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

import com.wahlbeck.advanceddota2stats.Utility.WebClientHelper;
import com.wahlbeck.advanceddota2stats.config.ConfigModel;

public class Scraper {
	
	public String getMatchHistory(String apiKey, String accountId) throws Exception {
		
		String sReturn = "";

		try {
			String baseURL = ConfigModel.getStringValue(ConfigModel.KEY_DOTA2_URI);
			WebClientHelper wch = new WebClientHelper(baseURL);
			ArrayList<String> pathElements = new ArrayList<String>();
			pathElements.add("IDOTA2Match_570");
			pathElements.add("GetMatchHistory");
			pathElements.add("v001");
			Map<String, String> m = new HashMap<String, String>();
			m.put("key", apiKey);
			m.put("account_id", accountId);
			sReturn = wch.invokeBasicGet(pathElements, m);
		} catch (Exception che)
		{
			System.out.println(che.getMessage());
		}
		
		return sReturn;
		
//		URL urlString = new URL("https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v001/?key=" + apikey + "&account_id=" + accountId);
//		BufferedReader in = new BufferedReader(new InputStreamReader(urlString.openStream()));
//		String inputLine;
//		String jsonResult = null;
//		while ((inputLine = in.readLine()) != null)
//			System.out.println(inputLine); 
//		in.close();
	}

}
