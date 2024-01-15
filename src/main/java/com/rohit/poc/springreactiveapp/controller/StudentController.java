package com.rohit.poc.springreactiveapp.controller;

import com.rohit.poc.springreactiveapp.dto.Student;
import com.rohit.poc.springreactiveapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(
            @Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @GetMapping(value = "/streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getStudentAsStream() {
        return studentService.getStudentAsStream();
    }
}
