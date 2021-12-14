import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EducationCRUD implements EducationDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    IO io;

    public EducationCRUD(IO io) {
        this.io = io;
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
