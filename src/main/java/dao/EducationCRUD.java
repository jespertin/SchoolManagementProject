package dao;

import entity.Course;
import entity.Education;
import entity.Student;
import utils.IO;

import javax.persistence.*;
import java.util.List;

public class EducationCRUD implements EducationDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    IO io;

    public EducationCRUD(IO io) {
        this.io = io;
    }

    @Override
    public void addEducation() {

        EntityManager em = emf.createEntityManager();

        io.printAnything("Name: ");
        String name = io.getString();

        Education education = new Education(name);

        System.out.println("Add Course(s)? (y/n): ");
        String yesOrNo = io.getString();

        if (yesOrNo.equalsIgnoreCase("y")) {
            em.createQuery("SELECT c FROM Course c", Course.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Course  id: ");
                education.addCourse(em.find(Course.class, io.getInt()));

                System.out.println("Another Course? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));

        }
        System.out.println("Add Students y/n");
        yesOrNo = io.getString();
        if (yesOrNo.equalsIgnoreCase("y")) {
            em.createQuery("SELECT s FROM Student s", Student.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Student id: ");
                education.addStudent(em.find(Student.class, io.getInt()));

                System.out.println("Another Student? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));
        }

        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateEducationName() {

        showAllEducations();

        io.printAnything("Education id: ");
        int id = io.getInt();

        io.printAnything("New name: ");
        String newName = io.getString();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, id);

        em.getTransaction().begin();
        education.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    public void removeCourseFromEducation(){
        EntityManager em = emf.createEntityManager();

        showAllEducations();
        io.printAnything("ID of education: ");
        Education e = em.find(Education.class,io.getInt());

        e.getCourses().forEach(io::printAnything);
        do {
            io.printAnything("ID of course to disconnect: ");
            Course c = em.find(Course.class,io.getInt());

            em.getTransaction().begin();
            e.removeCourse(c);
            em.getTransaction().commit();
            io.printAnything("Disconnect more courses? (y/n)");
        } while (io.getString().equalsIgnoreCase("y"));

        em.close();
    }

    public void printStudentsByEducation() {
        EntityManager em = emf.createEntityManager();

        showAllEducations();
        io.printAnything("ID of education: ");
        int id = io.getInt();
        em.find(Education.class, id)
                .getStudents()
                .forEach(io::printAnything);

    }

    public void printCoursesByEducation() {
        EntityManager em = emf.createEntityManager();

        showAllEducations();
        io.printAnything("ID of education: ");
        int id = io.getInt();
        em.find(Education.class, id)
                .getCourses()
                .forEach(io::printAnything);

    }


    @Override
    public void removeEducation() {

        EntityManager em = emf.createEntityManager();

        showAllEducations();

        io.printAnything("ID: ");
        int id = io.getInt();

        Education education = em.find(Education.class, id);
        List<Student> students = em.createQuery("select s from Student s where s.education=:param", Student.class)
                .setParameter("param", education)
                .getResultList();

        em.getTransaction().begin();
        for (Student student : students) {
            em.remove(student);
        }
        em.remove(education);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void showAllEducations() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> education = q.getResultList();

        education.forEach(e -> System.out.println(e));

        em.close();

    }


}
