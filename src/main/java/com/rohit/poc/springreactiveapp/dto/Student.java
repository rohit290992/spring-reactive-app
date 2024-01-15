package com.rohit.poc.springreactiveapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int rollNumber;
    private String name;
    private String course;
}
