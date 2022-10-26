package com.viglet.sling.client.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;

import com.viglet.sling.client.SlingUsernamePasswordCredentials;

/**
 * Client Utils
 * 
 * @author Alexandre Oliveira
 *
 */
public class SlingClientUtils {
	public static void basicAuth(HttpPost httpGet, SlingUsernamePasswordCredentials credentials) {
		if (credentials != null && credentials.getUsername() != null) {
			String auth = String.format("%s:%s", credentials.getUsername(), credentials.getPassword());
			String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
			String authHeader = "Basic " + encodedAuth;
			httpGet.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		}
	}
}
