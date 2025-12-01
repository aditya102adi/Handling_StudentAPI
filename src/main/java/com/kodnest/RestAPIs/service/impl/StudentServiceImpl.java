package com.kodnest.RestAPIs.service.impl;

import com.kodnest.RestAPIs.DTO.StudentDto;
import com.kodnest.RestAPIs.entity.Student;
import com.kodnest.RestAPIs.repositry.StudentRepository;
import com.kodnest.RestAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    private ModelMapper modelMapper;
    public void ModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        //convert students to studentDTO
        List<StudentDto> studentDtos = new ArrayList<>();

        for(Student stu: students) {
            StudentDto dto = new StudentDto();
            dto.setId(stu.getId());
            dto.setEmail(stu.getEmail());
            dto.setName(stu.getName());

            studentDtos.add(dto);
        }

        return studentDtos;
    }

    @Override
    public StudentDto getStudentByID(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
        return modelMapper.map(student, StudentDto.class);
    }
}
