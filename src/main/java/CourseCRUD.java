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

    }

    @Override
    public void updateCourseName() {

    }

    @Override
    public void removeCourse() {

    }

    @Override
    public void showAllCourses() {

    }
}
