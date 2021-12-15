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
                case 1 -> studentMenuSwitch();
                case 2 -> teacherMenuSwitch();
                case 3 -> educationMenuSwitch();
                case 0 -> keepGoing = false;

            }
        }
    }

    public void printMainMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Main Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Student Menu
                2. Teacher Menu
                3. Education Menu
                __________________________________________________
                """);
    }

    public void studentMenuSwitch(){
        boolean keepGoing = true;

        while (keepGoing) {
            printStudentMenu();
            int menuChoice = io.getInt();

            switch (menuChoice){
                case 1 -> studentCRUD.addStudent();
                case 2 -> studentCRUD.showAllStudents();
                case 3 -> studentCRUD.updateEducation();
                case 4 -> studentCRUD.updateStudentName();
                case 5 -> studentCRUD.updateStudentAge();
                case 6 -> studentCRUD.removeStudent();
                case 0 -> keepGoing = false;

            }
        }

    }

    public void printStudentMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Student Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Student
                2. Print all students
                3. Update Student Education
                4. Update Student Name
                5. Update Student Age
                6. Remove Student
                0. Back to main menu
               
                __________________________________________________
                """);
    }

    public void teacherMenuSwitch(){
        boolean keepGoing = true;

        while (keepGoing) {
            printTeacherMenu();
            int menuChoice = io.getInt();

            switch (menuChoice){
                case 1 -> teacherCRUD.addTeacher();
                case 2 -> teacherCRUD.showAllTeachers();
                case 3 -> teacherCRUD.updateTeacherName();
                case 4 -> teacherCRUD.removeTeacher();
                case 0 -> keepGoing = false;
            }
        }

    }

    public void printTeacherMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Teacher Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Teacher
                2. Print all teachers
                3. Update Teacher name
                4. Remove teacher
                0. Back to main menu
               
                __________________________________________________
                """);
    }

    public void educationMenuSwitch(){
        boolean keepGoing = true;

        while (keepGoing) {
            printEducationMenu();
            int menuChoice = io.getInt();

            switch (menuChoice){
                case 1 -> educationCRUD.addEducation();
                case 2 -> educationCRUD.showAllEducations();
                case 3 -> educationCRUD.updateEducationName();
                case 4 -> educationCRUD.removeEducation();
                case 5 -> educationCRUD.printStudentsByEducation();
                case 0 -> keepGoing = false;
            }
        }

    }

    public void printEducationMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                  Teacher Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add Education
                2. Print all educations
                3. Update education name
                4. Remove education
                5. Print all students of specific education
                0. Back to main menu
               
                __________________________________________________
                """);
    }
}
