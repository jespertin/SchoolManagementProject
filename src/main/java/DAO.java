import entity.Education;
import entity.Student;

public interface DAO {

    void addStudent();

    void updateStudentName();

    void updateStudentAge();

    void updateEducation();

    void showAllStudents();

    void removeStudent();

    void findStudentById();


    void addCourse();

    void updateCourseName();

    void removeCourse();

    void showAllCourses();


    void addTeacher();

    void updateTeacherName();

    void removeTeacher();

    void showAllTeachers();


    void addEducation();

    void updateEducationName();

    void removeEducation();

    void showAllEducations();






}
