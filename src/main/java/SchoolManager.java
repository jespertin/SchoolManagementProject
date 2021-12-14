import entity.Education;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolManager implements DAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    IO io;

    public SchoolManager(IO io) {
        this.io = io;
    }

    @Override
    public void addStudent() {
        EntityManager em = emf.createEntityManager();
        showAllEducations();
        io.printAnything("Choose education (by id): ");
        int id = io.getInt();
        Education education = em.find(Education.class,id);

        io.printAnything("Name: ");
        String name = io.getString();

        io.printAnything("Age: ");
        int age = io.getInt();
        Student student = new Student(name,age,education);

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateStudentName() {

    }

    @Override
    public void updateStudentAge() {

    }

    @Override
    public void updateEducation() {

    }

    @Override
    public void showAllStudents() {

    }

    @Override
    public void removeStudent() {

    }

    @Override
    public void findStudentById() {

    }

    @Override
    public void addCourse() {

    }

    @Override
    public void updateCourseName() {

    }

    @Override
    public void removeCourse() {

    }

    @Override
    public void showAllCourses() {

    }

    @Override
    public void addTeacher() {

    }

    @Override
    public void updateTeacherName() {

    }

    @Override
    public void removeTeacher() {

    }

    @Override
    public void showAllTeachers() {

    }

    @Override
    public void addEducation() {

    }

    @Override
    public void updateEducationName() {

    }

    @Override
    public void removeEducation() {

    }

    @Override
    public void showAllEducations() {

    }
}
