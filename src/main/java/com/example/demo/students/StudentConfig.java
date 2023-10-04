package com.example.demo.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository){
      return args -> {
      Students arlingga = new Students(
          "Arlingga",
          21,
          LocalDate.of(2001, Month.DECEMBER, 3),
          "acr02@gmail.com"
      );
      Students eko = new Students(
          "Eko",
          22,
          LocalDate.of(2001, Month.JULY, 1),
          "eko@gmail.com"
      );
      Students syauqi = new Students(
          "Syauqi",
          21,
          LocalDate.of(2001, Month.MAY, 5),
          "s072@gmail.com"
      );

      repository.saveAll( // JPA for Insert Into
        List.of(arlingga, eko, syauqi)
      );
    };
  }
}
