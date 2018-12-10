package com.ambonare.assignment.web.student;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ambonare.assignment.web.client.rest.StudentRestClient;

import dto.StudentDto;

@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean extends BaseBean {

	private List<StudentDto> allStudents;

	private StudentRestClient studentRestClient;

	private StudentDto currentStudent;

	public StudentBean() {
		studentRestClient = new StudentRestClient();
		allStudents = studentRestClient.findAllStudents();
	}

	public List<StudentDto> getAllStudents() {
		return allStudents;
	}

	public void setAllStudents(List<StudentDto> allStudents) {
		this.allStudents = allStudents;
	}

	public StudentDto getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(StudentDto currentStudent) {
		this.currentStudent = currentStudent;
	}

	public void prepareStudentForEdit(StudentDto currentStudent) {
		this.currentStudent = currentStudent;
		excuteJavaScript("$('#editStudentModal').modal('show');");
	}

	public void saveStudent() {
		studentRestClient.saveStudent(currentStudent);

		excuteJavaScript("$('#editStudentModal').modal('hide');");
		addSuccessMessage("Student " + currentStudent.getFirstName() + " updated successfully");
		currentStudent = null;
	}
}
