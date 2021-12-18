package dao;

import entity.Student;

public interface StudentDAO {

    void addStudent();

    void updateStudentName();

    void updateStudentAge();

    void updateEducation();

    void showAllStudents();

    void removeStudent();

    Student findStudentById();

}
