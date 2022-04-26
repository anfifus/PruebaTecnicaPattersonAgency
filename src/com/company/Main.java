package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option = 0;

        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

	    do {
            showOptionInMenu();
            option = chooseOption(option);
            Course course;
            switch (option){
                case 1-> teacherList.add(addTeacher());
                case 2-> studentList.add(addStudent());
                case 3-> assignTeacherAndStudentNewCourse(teacherList,studentList);
                case 4-> assignNotes(teacherList,studentList);
                case 5-> showNotesOfStudentsInTeacher(teacherList,studentList);
                case 6-> showAllNotesOfStudent(studentList);
                default -> System.out.println("Finishing the program");
            }
        }
        while (option!= 0);
    }

    private static void showAllNotesOfStudent(List<Student> studentList) {
        String studentName = writeNameOfStudent();
        for (Student currentStudent:studentList) {
            if(currentStudent.getName().equalsIgnoreCase(studentName)){
                for (Course currentCourse:currentStudent.getCourseList()) {
                    System.out.println("The student "+currentStudent.getName()+"have a "+currentCourse.getNote()+" in "+ currentCourse.getCourseName());
                }
            }
        }
    }

    private static String writeNameOfStudent() {
        System.out.println("Write the name of the student to show all his notes");
        return new Scanner(System.in).nextLine();
    }

    private static void showNotesOfStudentsInTeacher(List<Teacher> teacherList, List<Student> studentList) {
        String teacherName = writeNameOfTeacher();
        for (Teacher currentTeacher:teacherList) {
            System.out.println(currentTeacher.getName());
            if(currentTeacher.getName().equalsIgnoreCase(teacherName)){
                for (Course currentCourse:currentTeacher.getCourseList()) {
                    System.out.println("The teacher "+currentTeacher.getName()+" hase "+currentCourse.getStudentList().size()+" students");
                    for (Student currentStudent:currentCourse.getStudentList()) {
                        for(Course currentCourseInStudent :currentStudent.getCourseList())
                        {
                            if (currentCourse.getCourseName().equalsIgnoreCase(currentCourseInStudent.getCourseName())){
                                System.out.println("The student with name: "+currentStudent.getName()+" has a note of "+currentCourseInStudent.getNote()+" and is in course "+currentCourse.getCourseName());
                            }
                        }
                    }
                }
            }
        }
    }

    private static String writeNameOfTeacher() {
        System.out.println("Write the name of the teacher to show his students notes");
        return new Scanner(System.in).nextLine();
    }



    private static void assignNotes(List<Teacher> teacherList, List<Student> studentList) {
        for (Teacher currentTeacher:teacherList) {
            for (Course currentCourse:currentTeacher.getCourseList()) {
                for (Student currentStudent:studentList) {
                    for ( Course currentCourseInStudent : currentStudent.getCourseList()) {
                        if(currentCourse.getCourseName().equalsIgnoreCase(currentCourseInStudent.getCourseName())){
                            float note = addNewNote();
                            currentCourseInStudent.setNote(note);
                        }
                    }
                }
            }

        }
    }

    private static float addNewNote() {
        System.out.println("Write the note of the student");
        float note = new Scanner(System.in).nextFloat();
        return note;
    }

    private static void assignTeacherAndStudentNewCourse(List<Teacher> teacherList, List<Student> studentList) {
        Course newCourse = createCourse();
        for (Teacher currentTeacher:teacherList) {
            if(wantToAdd(currentTeacher) == true){
                currentTeacher.addCourse(newCourse);
            }

            for (Student currentStudent:studentList) {
                if(wantToAdd(currentStudent) == true){
                    currentStudent.addCourse(newCourse);
                    addStudentInTeacherClass(currentTeacher.getCourseList(),currentStudent);
                }
            }
        }
    }

    private static void addStudentInTeacherClass(List<Course> courseList, Student currentStudent) {
        for (Course currentCourse:courseList
             ) {
            if(!currentCourse.compareStudent(currentStudent)) {
                currentCourse.addStudent(currentStudent);
            }
            else{
                System.out.println("repeated");
            }
        }
    }

    private static boolean wantToAdd(Student Student) {
        System.out.println("Want to add the student"+Student.getName()+" into this course: ");
        return new Scanner(System.in).nextLine().equalsIgnoreCase("Y");
    }

    private static boolean wantToAdd(Teacher Teacher) {
        System.out.println("Want to add the course to this teacher: "+Teacher.getName());
        return new Scanner(System.in).nextLine().equalsIgnoreCase("Y");
    }

    private static Course createCourse() {
        String nameCourse;
        nameCourse = newNameCourse();
        Course course = new Course(nameCourse);
        return course;
    }

    private static String newNameCourse() {
        System.out.println("Which course do you want to create?");
        return new Scanner(System.in).nextLine();
    }

    private static Student addStudent() {
        String nameNewStudent = addNameToNewStudent();
        Student newStudent = new Student(nameNewStudent);
        return newStudent;
    }

    private static Teacher addTeacher() {
        String nameNewTeacher = addNameToNewTeacher();
        Teacher newTeacher = new Teacher(nameNewTeacher);
        return newTeacher;
    }
    private static String addNameToNewStudent() {
        System.out.println("Add the name of the new student");
        return new Scanner(System.in).nextLine();
    }

    private static String addNameToNewTeacher() {
        System.out.println("Add the name of the new teacher");
        return new Scanner(System.in).nextLine();
    }

    private static void showOptionInMenu() {
        System.out.println("1- Add teacher in School");
        System.out.println("2- Add student in School");
        System.out.println("3- Add course in School");
        System.out.println("4- Assign notes");
        System.out.println("5- Show all notes of students with the teacher name");
        System.out.println("6- Show all notes of student ");
        System.out.println("0- Exit program");
    }

    private static int chooseOption(int option) {
        option = writeOption();
        return option;
    }

    private static int writeOption() {
        System.out.println("Write the option you want");
        int option = new Scanner(System.in).nextInt();
        return option;
    }
}
