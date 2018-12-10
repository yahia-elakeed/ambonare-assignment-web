package com.ambonare.assignment.web.client.rest;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class RestClient {

	private final String REST_URI = "http://localhost:8090/";

	protected static final Logger LOGGER = Logger.getLogger(RestClient.class.getName());

	private Client client = ClientBuilder.newClient();

	public RestClient() {
		client.target(REST_URI);
	}

	public String getRestUri() {
		return REST_URI;
	}

	public Client getClient() {
		return client;
	}

}
