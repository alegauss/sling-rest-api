package com.viglet.sling.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.viglet.sling.client.utils.SlingClientUtils;

/**
 * Connect to Sling Server.
 * 
 * @author Alexandre Oliveira
 * 
 * @since 1.0.0
 */
public class SlingServer {

	private static Logger logger = Logger.getLogger(SlingServer.class.getName());
	private URL serverURL;
	private SlingUsernamePasswordCredentials credentials;

	public SlingServer(URL serverURL, SlingUsernamePasswordCredentials credentials) {
		super();
		this.serverURL = serverURL;
		this.credentials = credentials;

	}

	public URL getServerURL() {
		return serverURL;
	}

	public SlingUsernamePasswordCredentials getCredentials() {
		return credentials;
	}

	public void create(JCRNode jcrNode) {
		try {
			System.out.println(serverURL.toString().concat(jcrNode.getPath()));
			URIBuilder turingURL = new URIBuilder(serverURL.toString().concat(jcrNode.getPath()));

			if (this.getCredentials() != null) {
				HttpPost httpPost;

				httpPost = new HttpPost(turingURL.build());

				httpPost.setHeader(HttpHeaders.ACCEPT_ENCODING, StandardCharsets.UTF_8.name());

				List<NameValuePair> nvps = new ArrayList<>();
				jcrNode.entrySet().forEach(
						property -> nvps.add(new BasicNameValuePair(property.getKey(), (String) property.getValue())));
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

				SlingClientUtils.basicAuth(httpPost, this.getCredentials());
				try (CloseableHttpClient client = HttpClients.createDefault()) {
					client.execute(httpPost);
				} catch (IOException e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
				}

			}
		} catch (URISyntaxException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

	}
}
