import dao.CourseCRUD;
import dao.EducationCRUD;
import dao.StudentCRUD;
import dao.TeacherCRUD;
import statistics.SchoolStatistics;
import ui.UI;
import utils.IO;

public class Main {
    public static void main(String[] args) {
        IO io = new IO();

        StudentCRUD sd = new StudentCRUD(io);
        CourseCRUD cd = new CourseCRUD(io);
        TeacherCRUD tc = new TeacherCRUD(io);
        EducationCRUD ec = new EducationCRUD(io);
        SchoolStatistics sc = new SchoolStatistics();


        UI ui = new UI(io,cd,sd,tc,ec,sc);

        ui.mainMenuSwitch();
    }
}