public class UI {

    IO io;
    SchoolManager manager;

    public UI(IO io, SchoolManager manager) {
        this.io = io;
        this.manager = manager;
    }

    public void mainMenuSwitch(){
        boolean keepGoing = true;


        while (true) {
            int menuChoice = io.getInt();

            switch (menuChoice){
                case 1 -> manager.addCourse();
            }
        }

    }

    public void printMainMenu(){
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Main Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Add course
                2. 
                __________________________________________________
                """);
    }
}
