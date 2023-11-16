package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentCsvReader {

    public List<Student> processCsv(String filePath){
        List<Student> studentList = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath);
             ICsvListReader listReader = new CsvListReader(reader, CsvPreference.STANDARD_PREFERENCE)) {
            // 跳過header
            for (int i = 0; i < 2; i++) {
                listReader.read();
            }

            List<String> csvRow;
            Student currentStudent = null;
            while ((csvRow = listReader.read()) != null){
                currentStudent  = new Student();
                currentStudent.setName(csvRow.get(0));
                currentStudent.setAge(csvRow.get(1));
                currentStudent.setClasses(generateClasses(csvRow.get(2)));
                currentStudent.setCity(csvRow.get(3));
                currentStudent.setCountry(csvRow.get(4));
                studentList.add(currentStudent);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<Integer> generateClasses(String classesString) throws JsonProcessingException {
        if(classesString != null){
            classesString = "[" + classesString + "]";
            return objectMapper.readValue(classesString, new TypeReference<List<Integer>>() {
            });
        }

        return Collections.emptyList();
    }
}
