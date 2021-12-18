package dao;

import entity.Course;
import entity.Education;
import entity.Teacher;
import utils.IO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseCRUD implements CourseDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");


    IO io;

    public CourseCRUD(IO io) {
        this.io = io;
    }

    @Override
    public void addCourse() {
        EntityManager em = emf.createEntityManager();


        System.out.println("Name: ");
        String name = io.getString();

        Course course = new Course(name);

        System.out.println("Add Education(s)? (y/n): ");
        String yesOrNo = io.getString();

        if (yesOrNo.equalsIgnoreCase("y")) {
            em.createQuery("SELECT c FROM Education c", Education.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Education  id: ");
                course.addEducation(em.find(Education.class, io.getInt()));

                System.out.println("Another Education? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));

        }
        System.out.println("Add Teachers y/n");
        yesOrNo = io.getString();
        if (yesOrNo.equalsIgnoreCase("y")) {
            em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Teacher id: ");
                course.addTeacher(em.find(Teacher.class, io.getInt()));

                System.out.println("Another Teacher? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));
        }
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    public void addExistingCourseToExistingEducation(){
        EntityManager em = emf.createEntityManager();

        showAllCourses();
        io.printAnything("ID of course: ");
        int courseID = io.getInt();
        Course c = em.find(Course.class,courseID);

        em.createQuery("select e from Education e",Education.class)
                .getResultStream()
                .forEach(io::printAnything);
        io.printAnything("ID of education: ");
        int eduID = io.getInt();
        Education e = em.find(Education.class,eduID);

        em.getTransaction().begin();
        c.addEducation(e);
        em.getTransaction().commit();
        em.close();
    }

    public void printTeachersByCourse() {
        EntityManager em = emf.createEntityManager();

        showAllCourses();
        io.printAnything("ID of course: ");
        int id = io.getInt();
        em.find(Course.class, id)
                .getTeachers()
                .forEach(io::printAnything);
    }

    public void printEducationByCourse() {
        EntityManager em = emf.createEntityManager();

        showAllCourses();
        io.printAnything("ID of course: ");
        int id = io.getInt();
        em.find(Course.class, id)
                .getEducations()
                .forEach(io::printAnything);
    }


    @Override
    public void updateCourseName() {
        EntityManager em = emf.createEntityManager();

        showAllCourses();
        io.printAnything("Id of Course: ");
        int id = io.getInt();

        Course course = em.find(Course.class, id);

        io.printAnything("Update Course (by name)");
        String name = io.getString();

        em.getTransaction().begin();
        course.setName(name);
        em.getTransaction().commit();
        em.close();


    }

    @Override
    public void removeCourse() {

        EntityManager em = emf.createEntityManager();

        showAllCourses();
        io.printAnything("Remove Course (by id): ");
        int id = io.getInt();
        Course course = em.find(Course.class, id);


        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void showAllCourses() {
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT c FROM Course c", Course.class)
                .getResultList()
                .forEach(System.out::println);

        em.close();
    }
}