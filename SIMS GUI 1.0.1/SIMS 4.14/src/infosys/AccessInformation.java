package infosys;

/*
Provides options to the user for accessing data.
*/

import java.util.Scanner;

public class AccessInformation {

    Scanner scan = new Scanner(System.in);

    public void access() {
        // List options
        System.out.println("What do you wish to do?\n"
                + "    (1) List students\n"
                + "    (2) List papers\n"
                + "    (3) View student\n"
                + "    (4) View paper\n"
                + "    (x) (Go back)");
        String choose = scan.nextLine();
        switch (choose) {
            case "1":
                // Presents information and then prompts the user to return to the main menu
                new ManageStudents().list();
                new MainMenu().promptEnter();
                break;
            case "2":
                new ManagePapers().list();
                new MainMenu().promptEnter();
            //
            case "3":
                new ViewStudent().view();
                break;
            case "4":
                new ViewPaper().view();
                break;
            case "x":
                new MainMenu().mainMenu();
        }
    }
}
