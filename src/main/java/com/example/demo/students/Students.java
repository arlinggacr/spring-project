package com.example.demo.students;

import java.time.LocalDate;

public class Students {
  private Long student_id;
  private String student_name;
  private Integer age;
  private LocalDate dob;
  private String email;

  public Students(){
  }

  public Students(Long student_id, String student_name, Integer age, LocalDate dob, String email){
    this.student_id = student_id;
    this.student_name = student_name;
    this.age = age;
    this.dob = dob;
    this.email = email;
  }

  public Students(String student_name, Integer age, LocalDate dob, String email){
    this.student_name = student_name;
    this.age = age;
    this.dob = dob;
    this.email = email;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }

  public String getStudent_name() {
    return student_name;
  }

  public void setStudent_name(String student_name) {
    this.student_name = student_name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Students{" +
            "student_id=" + student_id +
            ", student_name='" + student_name + '\'' +
            ", age=" + age +
            ", dob=" + dob +
            ", email='" + email + '\'' +
            '}';
  }
}
