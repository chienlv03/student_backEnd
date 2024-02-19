package com.example.studentbackend.controller;

import com.example.studentbackend.dto.StudentDto;
import com.example.studentbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/student")

public class StudentController {

    private StudentService studentService;

    //Build Add Student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto saveStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }


    //Build Get Student
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    //Build Get All Student
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    //Build Update Student
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto updateStudent) {
        StudentDto studentDto = studentService.updateStudent(studentId, updateStudent);
        return ResponseEntity.ok(studentDto);
    }

    //Build Delete Student
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
