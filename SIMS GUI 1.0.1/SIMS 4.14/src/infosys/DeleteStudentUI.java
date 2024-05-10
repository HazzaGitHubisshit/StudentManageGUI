package infosys;

import java.util.Scanner;

public class DeleteStudentUI {

    private Student student;

    public void delete() {
        student = new FindStudent().find();
        if (student != null) {
            confirm();
        } else {
            System.out.println("Cancelled delete student.");
            new UpdateInformation().update();
        }
    }

    public void confirm() {
        System.out.println("Are you sure you wish delete " + student.getFullName() + "?\n"
                + "    (1) Confirm\n"
                + "    (2) Cancel");
        Scanner scan = new Scanner(System.in);
        String choose = scan.nextLine();
        switch (choose) {
            case "1":
                new DeleteStudent(student).delete();
                break;
            case "2":
            case "x":
                new UpdateInformation().update();
                break;
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }
}
