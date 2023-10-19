package com.example.demo.students;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //should be component but use service to be more semantics and more for readability
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired // this autoWired is same case like Injectable Controller
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository =  studentRepository;
  }
  public List<Students> getStudents(){
		return studentRepository.findAll();
	}

	public void addNewStudent(Students student){
		// adding validator that email has already taken
		Optional<Students> studentsOptional = studentRepository.findStudentsByEmail(student.getEmail());
		if(studentsOptional.isPresent()) {
			throw new IllegalStateException("email already taken");
		}
		// saving the data after validate the email
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean dataExits = studentRepository.existsById(studentId);
		if(!dataExits){
			throw new IllegalStateException("Data " + studentId +" not found");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String student_name, String email) {
		Students students = studentRepository.findById(studentId)
							.orElseThrow(() -> new IllegalStateException("student with id " + studentId + "does not exist"));
		// Checker the name of student
		if(student_name != null && !student_name.isEmpty() && !Objects.equals(students.getStudent_name(), student_name)) {
			students.setStudent_name(student_name);
		}

		//checker the email of student
		if(email != null && !email.isEmpty() && !Objects.equals(students.getEmail(), email)) {
			Optional<Students> studentsOptional = studentRepository.findStudentsByEmail(email);
			if(studentsOptional.isPresent()) {
				throw new IllegalStateException("Email Already Taken");
			}
			// then set email
			students.setEmail(email);
		}
	}
}
