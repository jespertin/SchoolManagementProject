import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherCRUD implements TeacherDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");


    IO io;

    public TeacherCRUD(IO io) {
        this.io = io;
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
}
