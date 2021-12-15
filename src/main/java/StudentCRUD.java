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

        em.createQuery("select e from Education e", Education.class)
                .getResultList()
                .forEach(io::printAnything);

        io.printAnything("Choose education (by id): ");
        int id = io.getInt();
        Education education = em.find(Education.class, id);

        io.printAnything("Name: ");
        String name = io.getString();

        io.printAnything("Age: ");
        int age = io.getInt();
        Student student = new Student(name, age, education);

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateStudentName() {
        EntityManager em = emf.createEntityManager();

        showAllStudents();
        io.printAnything("ID of student to update: ");
        int id = io.getInt();
        Student s = em.find(Student.class, id);
        io.printAnything("New name: ");
        String newName = io.getString();

        em.getTransaction().begin();
        s.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateStudentAge() {
        EntityManager em = emf.createEntityManager();

        showAllStudents();
        io.printAnything("ID of student to update: ");
        int id = io.getInt();
        Student s = em.find(Student.class, id);
        io.printAnything("New age: ");

        int newAge = io.getInt();

        em.getTransaction().begin();
        s.setAge(newAge);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateEducation() {
        EntityManager em = emf.createEntityManager();

        showAllStudents();
        io.printAnything("ID of student to update: ");
        int studentID = io.getInt();
        Student s = em.find(Student.class, studentID);

        em.createQuery("select e from Education e", Education.class)
                .getResultList()
                .forEach(io::printAnything);

        io.printAnything("New Education id: ");
        int eduID = io.getInt();
        Education newEdu = em.find(Education.class, eduID);

        em.getTransaction().begin();
        s.setEducation(newEdu);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void showAllStudents() {
        EntityManager em = emf.createEntityManager();

        io.printAnything("STUDENTS:");
        em.createQuery("select s from Student s", Student.class)
                .getResultList()
                .forEach(io::printAnything);
    }

    @Override
    public void removeStudent() {
        EntityManager em = emf.createEntityManager();

        Student s = findStudentById();

        s.getEducation().getStudents().remove(s);

        em.getTransaction().begin();
        em.remove(em.merge(s));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Student findStudentById() {
        EntityManager em = emf.createEntityManager();

        io.printAnything("ID of student: ");
        int id = io.getInt();

        return em.find(Student.class, id);
    }
}
