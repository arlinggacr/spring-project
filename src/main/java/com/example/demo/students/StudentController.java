package com.example.demo.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
  private final StudentService studentService;
  // but need to be instantiated like above

  @Autowired // this autoWired is same case like Injectable Controller
  public StudentController(StudentService studentService) {
    this.studentService =  studentService;
  }

  @GetMapping(value="/all-data")
  public List<Students> getStudent(){
    return studentService.getStudents();
  }
}
