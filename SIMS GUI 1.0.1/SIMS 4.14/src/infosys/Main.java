package infosys;

// The entry point for the program.

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our really super cool Student Information Management System. :)\n"
                + "N.B. Enter 'x' to cancel or back at any time.");
        new ReadDatabase().read();
        new MainMenu().mainMenu();
    }
}
