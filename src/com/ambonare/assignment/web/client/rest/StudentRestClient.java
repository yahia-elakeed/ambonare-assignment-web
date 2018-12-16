package com.ambonare.assignment.web.client.rest;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import dto.StudentDto;

public class StudentRestClient extends RestClient {

	private final String studentApiUrl;

	public StudentRestClient() {
		studentApiUrl = getRestUri() + API_PROPERTIES.getString("student.path");
	}

	public List<StudentDto> findAllStudents() {

		String uri = studentApiUrl + "all";

		LOGGER.info("Call rest API with URI " + uri + "to get all students");

		return getClient().target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<StudentDto>>() {
		});
	}

	public void saveStudent(StudentDto studentDto) {

		String uri = studentApiUrl + "save-student";

		LOGGER.info("Call rest API with URI " + uri + "to save or update student");

		getClient().target(uri).request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(studentDto, MediaType.APPLICATION_JSON));

	}

	public StudentDto getStudent(String firstName, String lastName) {

		String uri = studentApiUrl + "get-student?firstName=" + firstName + "&lastName=" + lastName;

		LOGGER.info("Call rest API with URI " + uri + "to get student");

		return getClient().target(uri).request(MediaType.APPLICATION_JSON).get(StudentDto.class);
	}
}
