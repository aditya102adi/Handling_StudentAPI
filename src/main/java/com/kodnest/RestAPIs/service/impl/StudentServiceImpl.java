package com.kodnest.RestAPIs.service.impl;

import com.kodnest.RestAPIs.DTO.AddStudentRequestDto;
import com.kodnest.RestAPIs.DTO.StudentDto;
import com.kodnest.RestAPIs.entity.Student;
import com.kodnest.RestAPIs.repositry.StudentRepository;
import com.kodnest.RestAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)) {
            throw  new IllegalArgumentException("Student does not exists by id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto upddateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));

        modelMapper.map(addStudentRequestDto, student); //update hojayega

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            String field = entry.getKey();
            Object value = entry.getValue();

            if (field.equals("name")) {
                student.setName((String) value);
            }
            else if (field.equals("email")) {
                student.setEmail((String) value);
            }
            else {
                throw new IllegalArgumentException("Field is not supported");
            }
        }

        Student saveStudent = studentRepository.save(student);
        return modelMapper.map(saveStudent,StudentDto.class);
    }
}
