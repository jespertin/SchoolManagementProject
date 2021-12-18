package statistics;

import entity.Education;
import entity.Student;
import entity.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

public class SchoolStatistics {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public void averageAgeOfStudents(){
        EntityManager em = emf.createEntityManager();

        em.createQuery("select s from Student s", Student.class)
                .getResultStream()
                .mapToDouble(Student::getAge)
                .average()
                .ifPresent(s -> System.out.println("Total Average:" + s + "\n"));

        System.out.println("By Education:");
        em.createQuery("select e from Education e",Education.class)
                .getResultStream()
                .forEach(e -> System.out.println( e.getName() + ": " + (e.getStudents().isEmpty() ? "" :
                        e.getStudents().stream().mapToDouble(Student::getAge).average().getAsDouble())));
    }

    public void numberOfStudentsInEducation(){
        EntityManager em = emf.createEntityManager();

        em.createQuery("select e from Education e", Education.class)
                .getResultStream()
                .forEach(s -> System.out.println(s.getName() + ": " +  s.getStudents().size()));
    }

    public void oldestStudent(){
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT s from Student s", Student.class)
                .getResultStream()
                .max(Comparator.comparingInt(Student::getAge))
                .ifPresent(System.out::println);
    }

    public void amountOfCoursesByTeacher(){
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT t from Teacher t", Teacher.class)
                .getResultStream()
                .forEach(t -> System.out.println(t.getName() + ": " + t.getCourses().size()));

    }

    public void youngestStudent(){
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT s from Student s", Student.class)
                .getResultStream()
                .min(Comparator.comparingInt(Student::getAge))
                .ifPresent(System.out::println);

    }

    public void numberOfTeachers(){
        EntityManager em = emf.createEntityManager();

        System.out.println("Total Number Of teachers: ");
        System.out.println(em.createQuery("select t from Teacher t", Teacher.class)
                .getResultStream()
                .count());
    }
}