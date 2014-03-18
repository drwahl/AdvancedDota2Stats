package com.wahlbeck.advanceddota2stats.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ad2s {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			//load properties file
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		scraper d2scraper = new scraper();
		d2scraper.getMatchHistory(prop.getProperty("apikey")); /*returns match history data*/
		dbdriver dbdriver = new dbdriver();
		dbdriver.updatedb(); /*update db with data from getMatchHistory*/
	}

}
