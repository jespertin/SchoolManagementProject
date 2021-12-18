package ui;

import dao.CourseCRUD;
import dao.EducationCRUD;
import dao.StudentCRUD;
import dao.TeacherCRUD;
import statistics.SchoolStatistics;
import utils.IO;

public class UI {

    IO io;
    CourseCRUD courseCRUD;
    StudentCRUD studentCRUD;
    TeacherCRUD teacherCRUD;
    EducationCRUD educationCRUD;
    SchoolStatistics statistics;

    public UI(IO io, CourseCRUD courseCRUD, StudentCRUD studentCRUD,
              TeacherCRUD teacherCRUD, EducationCRUD educationCRUD, SchoolStatistics statistics) {
        this.io = io;
        this.courseCRUD = courseCRUD;
        this.studentCRUD = studentCRUD;
        this.teacherCRUD = teacherCRUD;
        this.educationCRUD = educationCRUD;
        this.statistics = statistics;
    }


    public void mainMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printMainMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> studentMenuSwitch();
                case 2 -> teacherMenuSwitch();
                case 3 -> educationMenuSwitch();
                case 4 -> courseMenuSwitch();
                case 5 -> statsMenuSwitch();
                case 0 -> keepGoing = false;

            }
        }
    }

    public void printMainMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Main Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Student Menu
                2. Teacher Menu
                3. Education Menu
                4. Course Menu
                5. Statistics Menu
                0. Exit program
                __________________________________________________
                """);
    }

    public void statsMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printStatsMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> statistics.numberOfTeachers();
                case 2 -> statistics.oldestStudent();
                case 3 -> statistics.youngestStudent();
                case 4 -> statistics.numberOfStudentsInEducation();
                case 5 -> statistics.averageAgeOfStudents();
                case 6 -> statistics.amountOfCoursesByTeacher();
                case 0 -> keepGoing = false;

            }
        }

    }

    public void printStatsMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Statistics Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Total number of teachers
                2. Oldest Student
                3. Youngest Student
                4. Number of students in by education
                5. Average age of students
                6. Amount of courses ordered by teacher
                0. Back to main menu
                __________________________________________________
                """);
    }

    public void studentMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printStudentMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> studentCRUD.addStudent();
                case 2 -> studentCRUD.showAllStudents();
                case 3 -> studentCRUD.updateEducation();
                case 4 -> studentCRUD.updateStudentName();
                case 5 -> studentCRUD.updateStudentAge();
                case 6 -> studentCRUD.removeStudent();
                case 0 -> keepGoing = false;

            }
        }

    }

    public void printStudentMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Student Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Student
                2. Print all students
                3. Update Student Education
                4. Update Student Name
                5. Update Student Age
                6. Remove Student
                0. Back to main menu
                               
                __________________________________________________
                """);
    }

    public void teacherMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printTeacherMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> teacherCRUD.addTeacher();
                case 2 -> teacherCRUD.showAllTeachers();
                case 3 -> teacherCRUD.updateTeacherName();
                case 4 -> teacherCRUD.removeTeacher();
                case 5 -> teacherCRUD.printCoursesByTeacher();
                case 6 -> teacherCRUD.addExistingCourseToExistingEducation();
                case 7 -> teacherCRUD.removeCourseFromTeacher();
                case 0 -> keepGoing = false;
            }
        }

    }

    public void printTeacherMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Teacher Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Teacher
                2. Print all teachers
                3. Update Teacher name
                4. Remove teacher
                5. Print Course by teacher
                6. Connect Existing teacher to existing course
                7. Disconnect course from teacher
                0. Back to main menu
                               
                __________________________________________________
                """);
    }

    public void educationMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printEducationMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> educationCRUD.addEducation();
                case 2 -> educationCRUD.showAllEducations();
                case 3 -> educationCRUD.updateEducationName();
                case 4 -> educationCRUD.removeEducation();
                case 5 -> educationCRUD.printStudentsByEducation();
                case 6 -> educationCRUD.printCoursesByEducation();
                case 7 -> educationCRUD.removeCourseFromEducation();
                case 0 -> keepGoing = false;
            }
        }

    }

    public void printEducationMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Education Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Education
                2. Print all educations
                3. Update education name
                4. Remove education
                5. Print all students of specific education
                6. Print all courses of specific education
                7. Disconnect course from education
                0. Back to main menu
                               
                __________________________________________________
                """);
    }



    public void courseMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printCourseMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> courseCRUD.addCourse();
                case 2 -> courseCRUD.showAllCourses();
                case 3 -> courseCRUD.updateCourseName();
                case 4 -> courseCRUD.removeCourse();
                case 5 -> courseCRUD.printTeachersByCourse();
                case 6 -> courseCRUD.printEducationByCourse();
                case 7 -> courseCRUD.addExistingCourseToExistingEducation();
                case 0 -> keepGoing = false;
            }
        }

    }

    public void printCourseMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Course Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Course
                2. Print all Courses
                3. Update Course name
                4. Remove Course
                5. Print Teachers by course
                6. Print Education by course
                7. Connect course to education
                0. Back to main menu
                               
                __________________________________________________
                """);
    }


}