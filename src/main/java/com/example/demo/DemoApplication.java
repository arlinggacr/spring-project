package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.demo.students.Students;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping
	public List<Students> testApi(){
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
