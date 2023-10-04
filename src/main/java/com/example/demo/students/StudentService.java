package com.example.demo.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //should be component but use servie to be more semantics and more for readability
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired // this autoWired is same case like Injectable Controller
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository =  studentRepository;
  }
  public List<Students> getStudents(){
		return studentRepository.findAll();
	}
}
