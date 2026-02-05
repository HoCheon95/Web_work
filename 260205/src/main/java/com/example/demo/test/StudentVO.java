package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {
    private String name;
    private int age;
    private String addr;
    private String tel;
    
}
