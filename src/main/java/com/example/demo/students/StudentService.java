package com.example.demo.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //should be component but use servie to be more semantics and more for readability
public class StudentService {
  public List<Students> getStudents(){
		return List.of(
			new Students(
			1L,
			"Arlingga",
			21,
			LocalDate.of(2000, Month.JANUARY, 5),
			"acr02@gmail.com"
		));
	}
}
