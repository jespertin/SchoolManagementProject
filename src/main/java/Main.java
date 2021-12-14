public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        SchoolManager manager = new SchoolManager(io);

        UI ui = new UI(io,manager);

        ui.mainMenuSwitch();

    }
}
