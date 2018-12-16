package com.ambonare.assignment.web.client.rest;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class RestClient {

	private final String REST_URI;

	protected static final Logger LOGGER = Logger.getLogger(RestClient.class.getName());

	protected static final ResourceBundle API_PROPERTIES;

	private Client client = ClientBuilder.newClient();

	public RestClient() {
		this.REST_URI = API_PROPERTIES.getString("rest.base_url");
		client.target(REST_URI);
	}

	public String getRestUri() {
		return REST_URI;
	}

	public Client getClient() {
		return client;
	}

	static {
		API_PROPERTIES = ResourceBundle.getBundle("resources.restapi");
	}

}
