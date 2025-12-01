package com.kodnest.RestAPIs.service;

import com.kodnest.RestAPIs.DTO.StudentDto;
import com.kodnest.RestAPIs.entity.Student;

import  java.util.*;
public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentByID(Long id);
}
