package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    static Scanner sc = new Scanner(System.in);

    public String getString() {
        return sc.nextLine();
    }

    public int getInt() {
        int num = 0;
        boolean keepGoing = true;

        while (keepGoing) {
            try {
                num = sc.nextInt();
                keepGoing = false;

            } catch (InputMismatchException e) {
                printAnything("Only numerical values with no decimals accepted, try again.");

            } finally {
                sc.nextLine();
            }
        }
        return num;
    }

    public <T> void printAnything(T t) {
        System.out.println(t);
    }

    public void exit() {
        System.exit(0);
    }

    public void pauseCode() {
        printAnything("Press enter to continue");
        sc.nextLine();
    }
}