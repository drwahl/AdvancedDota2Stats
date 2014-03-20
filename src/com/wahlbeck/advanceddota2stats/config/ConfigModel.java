package com.wahlbeck.advanceddota2stats.config;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ConfigModel {
	
	private static Properties props = null;
	
	public static final String KEY_DOTA2_APIKEY = "config.dota2api.key";
	public static final String KEY_DOTA2_URI = "config.dota2api.uri";
	
	public static synchronized void loadProperties() {
		try {
			// Load the properties from the file if they havent already been loaded.
			if(props == null) {
				props = new Properties();
				//_logger.debug("about to load config.properties");
				props.load(ConfigModel.class.getResourceAsStream("/config.properties"));
				//_logger.debug("finished loading config.properties");
			}
			
			// Here we would probably want to dump all of the properties out to a log file
			Set<Entry<Object,Object>> entries = props.entrySet();
			for (Entry<Object,Object> entry : entries) {
				//_logger.info("	Property (" + entry.getKey() + "), Value (" + entry.getValue());
			}
		} catch (Exception ex) {
			//_logger.error(config.properties failed to load - " + ex.getMessage());
		}
		
		return;
	}
	
	public static long getLongValue (String key) {
		if (props == null)
			loadProperties();
		long ret = 0L;
		try {
			String s = props.getProperty(key);
			ret = Long.parseLong(s);
		} catch (Exception ex) {
			//_logger.warn("Requested config parameter not found or in wrong format: " + key);
		}
		
		return ret;
	}

	public static int getIntValue (String key) {
		if (props == null)
			loadProperties();
		int ret = 0;
		try {
			String s = props.getProperty(key);
			ret = Integer.parseInt(s);
		} catch (Exception ex) {
			//_logger.warn("Requested config parameter not found or in wrong format: " + key);
		}
		
		return ret;
	}
	
	public static String getStringValue (String key) {
		if (props == null)
			loadProperties();
		String ret = "";
		try {
			ret = props.getProperty(key);
		} catch (Exception ex) {
			//_logger.warn("Requested config parameter not found or in wrong format: " + key);
		}
		
		return ret;
	}

}
