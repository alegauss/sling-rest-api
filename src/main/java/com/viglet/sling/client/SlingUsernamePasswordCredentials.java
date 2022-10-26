package com.viglet.sling.client;

/**
 * Sling Server Credentials.
 * 
 * @author Alexandre Oliveira
 * 
 * @since 1.0.0
 */
public class SlingUsernamePasswordCredentials implements SlingCredentials {

	private String username;

	private String password;

	public SlingUsernamePasswordCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
