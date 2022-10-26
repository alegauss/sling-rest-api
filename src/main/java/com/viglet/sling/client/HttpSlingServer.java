package io.vilt.sling.client;

import java.net.URL;

/**
 * HTTP of HttpSlingServer.
 * 
 * @author Alexandre Oliveira
 * 
 * @since 1.0.0
 */
public class HttpSlingServer extends SlingServer {

	public HttpSlingServer(URL serverURL, SlingUsernamePasswordCredentials credentials) {
		super(serverURL, credentials);

	}


}
