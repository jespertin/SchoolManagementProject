public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        StudentCRUD sd = new StudentCRUD(io);
        CourseCRUD cd = new CourseCRUD(io);
        TeacherCRUD tc = new TeacherCRUD(io);
        EducationCRUD ec = new EducationCRUD(io);

        UI ui = new UI(io,cd,sd,tc,ec);

        ui.mainMenuSwitch();
    }
}
