package com.rohit.poc.springreactiveapp.service;

import com.rohit.poc.springreactiveapp.dao.StudentDao;
import com.rohit.poc.springreactiveapp.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudent() {
        return studentDao.getStudent();
    }

    public Flux<Student> getStudentAsStream() {
        return studentDao.getStudentAsStream();
    }
}
