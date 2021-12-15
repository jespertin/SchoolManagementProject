import entity.Education;

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

        em.getTransaction().begin();
        em.persist(education);

        em.getTransaction().commit();
        em.close();

        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> q = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> education = q.getResultList();

        education.forEach(e -> System.out.println(e));

        em.close();

    }


    @Override
    public void updateEducation() {

        showAllEducations();

        io.printAnything("Education Id: ");
        int id = io.getInt();

        io.printAnything("Name: ");
        String name = io.getString();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, id);

        em.getTransaction().begin();
        education.setName(name);

        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateEducationName() {

        showAllEducations();

        io.printAnything("Educaton id: ");
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

    public void printStudentsByEducation(){
        EntityManager em = emf.createEntityManager();

        showAllEducations();
        io.printAnything("ID of education: ");
        int id = io.getInt();
        em.find(Education.class,id)
                .getStudents()
                .forEach(io::printAnything);

    }


    @Override
    public void removeEducation() {

        EntityManager em = emf.createEntityManager();

        showAllEducations();

        io.printAnything("ID: ");
        int id = io.getInt();

        Education education = em.find(Education.class, id);

        em.getTransaction().begin();
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
