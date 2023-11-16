package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {

    private List<Student> studentList;
    @Value("${file.path:#{null}}")
    private String filePath;
    @PostConstruct
    public void initList(){
        if(filePath != null){
            StudentCsvReader studentCsvReader = new StudentCsvReader();
            studentList = studentCsvReader.processCsv(filePath);
        }else {

            studentList = Collections.emptyList();
        }
    }
    @GetMapping("test")
    public List<Student> test(){
        return studentList;
    }
}
