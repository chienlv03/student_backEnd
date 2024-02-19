package com.example.studentbackend.service;

import com.example.studentbackend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentId, StudentDto updateStudent);

    void deleteStudent(Long studentId);
}
