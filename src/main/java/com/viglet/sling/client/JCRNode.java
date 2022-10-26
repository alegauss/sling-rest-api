package com.viglet.sling.client;

import java.util.LinkedHashMap;

public class JCRNode extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 6380574732565098822L;

	private String path;

	public JCRNode(String path) {
		super();
		this.path = path;
	}

	public void setPrimaryType(String value) {
		this.put("jcr:primaryType", value);
	}

	public String getPath() {
		return path;
	}

}
