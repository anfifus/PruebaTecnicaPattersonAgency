package com.company;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private float note;
    private List<Student> studentList;

    public Course(String courseName) {
        this.courseName = courseName;
        studentList = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student newStudent) {
        this.studentList.add(newStudent);
    }
    public boolean compareStudent(Student newStudent){
       return this.studentList.contains(newStudent);
    }
}
