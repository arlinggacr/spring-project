package com.example.demo.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
  private final StudentService studentService;
  // but need to be instantiated like above

  @Autowired // this autoWired is same case like Injectable Controller
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path="/all-data")
  public List<Students> getStudent(){
    return studentService.getStudents();
  }

  @PostMapping(path="/register")
  public void registerNewStudent(@RequestBody Students student){
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path="/delete/{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  @PutMapping(path="/update-data/{studentId}")
  public void updateStudent(@PathVariable("studentId") Long studentId,
                            @RequestParam(required = false) String student_name,
                            @RequestParam(required = false) String email) {
    studentService.updateStudent(studentId, student_name, email);
  }
}
