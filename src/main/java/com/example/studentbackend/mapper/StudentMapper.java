package com.example.studentbackend.mapper;

import com.example.studentbackend.dto.StudentDto;
import com.example.studentbackend.entity.Student;

import java.sql.Date;

public class StudentMapper {

    public  static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                (Date) student.getDate(),
                student.getAddress(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getDate(),
                studentDto.getEmail(),
                studentDto.getAddress()
        );
    }


}
