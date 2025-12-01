package com.kodnest.RestAPIs.service;

import com.kodnest.RestAPIs.DTO.AddStudentRequestDto;
import com.kodnest.RestAPIs.DTO.StudentDto;
import com.kodnest.RestAPIs.entity.Student;

import  java.util.*;
public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentByID(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto upddateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
