package com.example.demo.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>{

    @Query("SELECT s FROM Students s WHERE s.email = ?1")
    Optional<Students> findStudentsByEmail(String email);
}