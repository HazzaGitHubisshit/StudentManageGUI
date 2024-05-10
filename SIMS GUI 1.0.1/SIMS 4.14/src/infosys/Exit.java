package infosys;

import java.util.Scanner;

public class Exit {

    public void exit() {
        System.out.println("Are you sure you wish to exit?\n"
                + "    (1) Confirm\n"
                + "    (2) (Cancel)");
        Scanner scan = new Scanner(System.in);
        String choose = scan.nextLine();
        switch (choose) {
            case "1":
                System.out.println("Goodbye!");
                System.exit(0);
            case "2":
                new MainMenu().mainMenu();
            default:
                System.out.println("Invalid input.");
                exit();
        }
    }
}
