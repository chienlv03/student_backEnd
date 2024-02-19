package com.example.studentbackend.service.impl;

import com.example.studentbackend.dto.StudentDto;
import com.example.studentbackend.entity.Student;
import com.example.studentbackend.exception.ResourceNotFoundException;
import com.example.studentbackend.mapper.StudentMapper;
import com.example.studentbackend.repository.StudentRepository;
import com.example.studentbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saveStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(saveStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student is not exits with given id: " + studentId));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateStudent) {

        Student student =  studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student is not exits with given id: " + studentId)
        );

        student.setFirstName(updateStudent.getFirstName());
        student.setLastName(updateStudent.getLastName());
        student.setDate(updateStudent.getDate());
        student.setAddress(updateStudent.getAddress());
        student.setEmail(updateStudent.getEmail());

        Student updateStudentObj =  studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updateStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student =  studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student is not exits with given id: " + studentId)
        );

        studentRepository.deleteById(studentId);
    }
}
