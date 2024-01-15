package com.rohit.poc.springreactiveapp.dao;

import com.rohit.poc.springreactiveapp.dto.Student;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class StudentDao {

    private void sleepThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudent() {
        return IntStream
                .rangeClosed(1, 50)
                .peek(x -> sleepThread())
                .peek(x -> System.out.println("processing count " + x))
                .mapToObj(i -> new Student(i, "Student" + i, "Course" + i))
                .collect(Collectors.toList());
    }

    public Flux<Student> getStudentAsStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(x -> System.out.println("processing count " + x))
                .map(i -> new Student(i, "Student" + i, "Course" + i));
    }
}
