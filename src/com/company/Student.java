package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courseList;


    public Student(String name) {
        this.name = name;
        courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course newCourse) {
        this.courseList.add(newCourse);
    }
}
