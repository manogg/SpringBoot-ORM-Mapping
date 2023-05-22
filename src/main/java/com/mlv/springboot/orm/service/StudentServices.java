package com.mlv.springboot.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlv.springboot.orm.entity.Student;
import com.mlv.springboot.orm.entity.Subjects;
import com.mlv.springboot.orm.repository.StudentRepository;
import com.mlv.springboot.orm.repository.SubjectRepository;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	public Student saveStudentWithSubjects(Student student) {

		return studentRepository.save(student);
	}

	public List<Student> findAllStudent() {

		return studentRepository.findAll();
	}

	public List<Student> findByStudentName(String name) {

		return studentRepository.findByNameContaining(name);
	}

	public List<Subjects> findAllSubjects() {

		return subjectRepository.findAll();
	}
	
	public List<Subjects> findByFees(int fees){
		
		return subjectRepository.findByFeesLessThan(fees);
	}

}
