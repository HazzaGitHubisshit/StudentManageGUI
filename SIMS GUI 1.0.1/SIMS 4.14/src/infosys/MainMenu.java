package infosys;

/*
This is the entry point for the user interface. When a UI path is exhausted, it
should return back to the MainMenu.
*/

import java.util.Scanner;

public class MainMenu {

    Scanner scan = new Scanner(System.in);

    // promptEnter() returns the user to the main menu after at task has been completed.
    public void promptEnter() {
        System.out.println("(Press ENTER to continue)");
        scan.nextLine();
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("What do you wish to do?\n"
                + "    (1) Access information\n"
                + "    (2) Update information\n"
                + "    (3) Exit program");
        String userInput = scan.nextLine();
        switch (userInput) {
            case "1":
                new AccessInformation().access();
                break;
            case "2":
                new UpdateInformation().update();
                break;
            case "x":
            case "3":
                new Exit().exit();
                break;
            default:
                System.out.println("Invalid input.");
                mainMenu();
        }
    }
}
