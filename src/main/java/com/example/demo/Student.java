package com.example.demo;

import java.util.List;

public class Student {
    private String name;
    private String age;
    private List<Integer> classes;
    private String city;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Integer> getClasses() {
        return classes;
    }

    public void setClasses(List<Integer> classes) {
        this.classes = classes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{name:'").append(name).append('\'');
        sb.append(", age:'").append(age).append('\'');
        sb.append(", classes:").append(classes);
        sb.append(", city:'").append(city).append('\'');
        sb.append(", country:'").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
