import entity.Course;
import entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherCRUD implements TeacherDAO{
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    public IO io;

    public TeacherCRUD(IO io) {
        this.io = io;
    }

    @Override
    public void addTeacher() {
        EntityManager em = emf.createEntityManager();

        System.out.println("Name: ");
        String name = io.getString();

        Teacher teacher = new Teacher(name);

        System.out.println("Add course(s)? (y/n): ");
        String yesOrNo = io.getString();

        if (yesOrNo.equalsIgnoreCase("y")) {
            em.createQuery("SELECT c FROM Course c", Course.class).getResultStream().forEach(System.out::println);

            do {
                System.out.println("Course id: ");
                teacher.addCourse(em.find(Course.class, io.getInt()));

                System.out.println("Another course? (y/n): ");
            } while (io.getString().equalsIgnoreCase("y"));
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
