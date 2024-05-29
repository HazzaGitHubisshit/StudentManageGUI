package Model;

import java.util.Scanner;

public class UpdateInformation {

    Scanner scan = new Scanner(System.in);

    public void update() {
        System.out.println("What do you wish to do?\n"
                + "    (1) Add a new student\n"
                + "    (2) Delete a student\n"
                + "    (3) Assign a paper\n"
                + "    (4) Disassign a paper\n"
                + "    (5) Add a new paper\n"
                + "    (6) Delete a paper\n"
                + "    (x) (Go back)");
        String choose = scan.nextLine();

        switch (choose) {
            case "x":
                new MainMenu().mainMenu();
                break;
            case "1":
                new AddStudentUI().add();
                break;
            case "2":
                new DeleteStudentUI().delete();
                break;
            case "3":
                new AssignPaperUI().assign();
                break;
            case "4":
                new DisassignPaperUI().disassign();
                break;
            case "5":
                new AddPaperUI().add();
                break;
            case "6":
                new DeletePaperUI().delete();
                break;
            default:
                System.out.println("Invalid input.");
                update();
        }
    }
}
