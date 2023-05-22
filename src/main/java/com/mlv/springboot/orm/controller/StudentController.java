package com.mlv.springboot.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlv.springboot.orm.dto.Responses;
import com.mlv.springboot.orm.entity.Student;
import com.mlv.springboot.orm.entity.Subjects;
import com.mlv.springboot.orm.service.StudentServices;

@RestController
@RequestMapping("/student/subject")
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@PostMapping
	public Responses<Responses> saveStudentWithSubjects(@RequestBody Student student) {

		Student savedStudents = studentServices.saveStudentWithSubjects(student);

		return new Responses("SUCESS", 1, savedStudents);

	}

	@GetMapping
	public Responses<List<Student>> findAllStudents() {

		List<Student> foundStudent = studentServices.findAllStudent();

		return new Responses<>("SUCESS", foundStudent.size(), foundStudent);
	}

	@GetMapping("/{name}")
	public Responses<List<Student>> findAllStudentsWithName(@PathVariable("name") String name) {

		List<Student> foundStudentByName = studentServices.findByStudentName(name);

		return new Responses<>("SUCESS", foundStudentByName.size(), foundStudentByName);
	}

	@GetMapping("/sub")
	public Responses<List<Subjects>> findAllSubjects() {

		List<Subjects> savedSubjects = studentServices.findAllSubjects();

		return new Responses<>("SUCESS", savedSubjects.size(), savedSubjects);
	}

	@GetMapping("/sub/{fees}")
	public Responses<List<Subjects>> findAllSubjectsByFees(@PathVariable("fees") int fees) {

		List<Subjects> findALLSubjectsByFees = studentServices.findByFees(fees);

		return new Responses<>("SUCESS", findALLSubjectsByFees.size(), findALLSubjectsByFees);
	}

}
