import entity.Education;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentCRUD implements StudentDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    IO io;

    public StudentCRUD(IO io) {
        this.io = io;
    }

    @Override
    public void addStudent() {
        EntityManager em = emf.createEntityManager();

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
}
