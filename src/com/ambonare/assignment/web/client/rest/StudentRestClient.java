package com.ambonare.assignment.web.client.rest;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import dto.StudentDto;

public class StudentRestClient extends RestClient {

	private final String STUDENT_REST_URI;

	public StudentRestClient() {
		STUDENT_REST_URI = getRestUri() + "students/";
	}

	public List<StudentDto> findAllStudents() {

		String uri = STUDENT_REST_URI + "all";

		LOGGER.info("Call rest API with URI " + uri + "to get all students");

		return getClient().target(uri).request(MediaType.APPLICATION_JSON).get(new GenericType<List<StudentDto>>() {
		});
	}

	public void saveStudent(StudentDto studentDto) {

		String uri = STUDENT_REST_URI + "save-student";

		LOGGER.info("Call rest API with URI " + uri + "to save or update student");

		getClient().target(uri).request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(studentDto, MediaType.APPLICATION_JSON));

	}
}
