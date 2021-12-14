import entity.Course;
import entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TeacherCRUD implements TeacherDAO{
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    public IO io;

    public TeacherCRUD(IO io) {
        this.io = io;
    }

    @Override
    public void addTeacher() {
        EntityManager em = emf.createEntityManager();
        Teacher teacher;

        System.out.println("Name: ");
        String name = io.getString();

        System.out.println("Add course(s)? (y/n): ");
        String yesOrNo = io.getString();

        if (yesOrNo.equalsIgnoreCase("y")) {
            List<Course> courses = new ArrayList<>();
            em.createQuery("SELECT c FROM Course c", Course.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Course id: ");
                courses.add(em.find(Course.class, io.getInt()));

                System.out.println("Another course? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));

            teacher = new Teacher(name, courses);
        } else {
            teacher = new Teacher(name);
        }

        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateTeacherName() {
        EntityManager em = emf.createEntityManager();

        showAllTeachers();
        Teacher teacher = getTeacherById();

        System.out.println("New name: ");
        String name = io.getString();
        teacher.setName(name);

        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeTeacher() {
        EntityManager em = emf.createEntityManager();

        showAllTeachers();
        Teacher teacher = getTeacherById();

        em.getTransaction().begin();
        em.remove(em.merge(teacher));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void showAllTeachers() {
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultStream().forEach(System.out::println);
    }

    public Teacher getTeacherById() {
        EntityManager em = emf.createEntityManager();

        System.out.println("Teacher id: ");
        int id = io.getInt();

        return em.find(Teacher.class, id);
    }
}
