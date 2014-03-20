package com.wahlbeck.advanceddota2stats.Utility;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class WebClientHelper {
	
	private int _connectTimeout = 10000;
	private int _readTimeout = 30000;
	
	private String _baseURL = "";

	public WebClientHelper() 
	{
	}
	
	public WebClientHelper(String baseURL) {
		_baseURL = baseURL;
	}
	
	public WebClientHelper(String baseURL, int connectTimeoutMillis, int readTimeoutMillis)
	{
		_baseURL = baseURL;
		_connectTimeout = connectTimeoutMillis;
		_readTimeout = readTimeoutMillis;
	}
	
	public String getBaseURL() {
		return _baseURL;
	}
	
	public void setBaseURL(String baseURL) {
		this._baseURL = baseURL;
	}
	
	public int getReadTimeout() {
		return _readTimeout;
	}
	
	public void setReadTimout(int readTimout) {
		this._readTimeout = readTimout;
	}

	public int getConnectTimeout() {
		return _connectTimeout;
	}
	
	public void setConnectTimout(int connectTimeout) {
		this._connectTimeout = connectTimeout;
	}
	
	public String invokeBasicGet (List<String> pathElements, Map<String,String> queryParams) {
		
		//_logger.debug("<Enter>");
		String sReturn = "";
		
		try {
			ClientConfig config = new DefaultClientConfig();
			config.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, this.getConnectTimeout());
			config.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT,  this.getReadTimeout());
			Client client = Client.create(config);
			WebResource service = client.resource(this.getBaseURL());
			Builder bldr = null;
			
			//add the path elements that are passed in
			if(pathElements != null) {
				for (String sPathElement : pathElements)
				{
					service = service.path(sPathElement);
				}
			}
			
			//add the query Params that are passed in
			if(queryParams != null) {
				for (String sKey : queryParams.keySet())
					service = service.queryParam(sKey, queryParams.get(sKey));
			}
			
			bldr = service.accept(MediaType.APPLICATION_JSON);
			
			ClientResponse cr = bldr.get(ClientResponse.class);
			String entityString = cr.getEntity(String.class);
			//_logger.debug("Status returned: " + cr.getStatus());
			
			if (cr.getStatus() < 200 || cr.getStatus() > 299)
			{
				//_logger.warn("Server returned non-200 response code: " + cr.getStatus());
				//_logger.warn("Returned message: " + entityString);
				//throw an exception
			}
			sReturn = entityString;
			
		} catch (ClientHandlerException che)
		{
			//_logger.warn("An error occurred: " + che.getMessage());
			//throw an exception
		} catch (UniformInterfaceException we)
		{
			//_logger.warn("UniformInterfaceException: " + che.getMessage());
			//throw an exception
		}
		
		return sReturn;
	}
	

}
