package com.kodnest.RestAPIs.repositry;

import com.kodnest.RestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends  JpaRepository <Student, Long> {
}
