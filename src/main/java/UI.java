public class UI {

    IO io;
    CourseCRUD courseCRUD;
    StudentCRUD studentCRUD;
    TeacherCRUD teacherCRUD;
    EducationCRUD educationCRUD;

    public UI(IO io, CourseCRUD courseCRUD, StudentCRUD studentCRUD, TeacherCRUD teacherCRUD, EducationCRUD educationCRUD) {
        this.io = io;
        this.courseCRUD = courseCRUD;
        this.studentCRUD = studentCRUD;
        this.teacherCRUD = teacherCRUD;
        this.educationCRUD = educationCRUD;
    }


    public void mainMenuSwitch(){
        boolean keepGoing = true;


        while (keepGoing) {
            printMainMenu();
            int menuChoice = io.getInt();

            switch (menuChoice){
                case 1 -> studentCRUD.addStudent();

            }
        }

    }

    public void printMainMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Main Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Student
                2. 
                __________________________________________________
                """);
    }
}
