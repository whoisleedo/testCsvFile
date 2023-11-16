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
    // 準備當作return的回傳物件
    private List<Student> studentList;

    //由application.properties注入csv file path
    @Value("${file.path:#{null}}")
    private String filePath;

    // 在controller 初始化後先執行的方法
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
