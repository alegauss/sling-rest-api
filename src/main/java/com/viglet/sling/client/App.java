package io.vilt.sling.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
	private static Logger logger = Logger.getLogger(App.class.getName());

	private static final String SLING_URL = "http://centos7:4502";
	private static final String SLING_USERNAME = "admin";
	private static final String SLING_PASSWORD = "admin";

	public static void main(String[] args) {
		try {
			HttpSlingServer slingServer = new HttpSlingServer(new URL(SLING_URL),
					new SlingUsernamePasswordCredentials(SLING_USERNAME, SLING_PASSWORD));
			
			JCRNode jcrNode = new JCRNode("/content/hello3");
			jcrNode.setPrimaryType("sling:Folder");
			jcrNode.put("name", "Alexandre");
			jcrNode.put("city", "São Paulo");
			
			slingServer.create(jcrNode);
		} catch (MalformedURLException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
