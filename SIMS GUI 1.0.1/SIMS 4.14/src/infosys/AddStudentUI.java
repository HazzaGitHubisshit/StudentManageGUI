package infosys;

import java.util.Scanner;

public class AddStudentUI {

    private Student student;
    EditStudent edit;

    public AddStudentUI() {
        this.student = new Student(null, null, null, null);
        this.edit = new EditStudent(student);
    }

    Scanner scan = new Scanner(System.in);

    public void add() {
        if (student != null) {
            if (student.getStudentID() == null) {
                student = edit.setStudentID();
                add();
            } else if (student.getSurname() == null) {
                student = edit.setSurname();
                add();
            } else if (student.getFirstName() == null) {
                student = edit.setFirstName();
                add();
            } else if (student.getDateOfBirth() == null) {
                student = edit.setDateOfBirth();
                add();
            } else {
                confirm();
            }
        } else {
            cancel();
        }
    }

    // User cancels: return to previous menu
    public void cancel() {
        System.out.println("Student creation cancelled.");
        new UpdateInformation().update();
    }

    public void confirm() {
        System.out.println("    (1) Confirm and add to database\n"
                + "    (2) Edit student ID\n"
                + "    (3) Edit surname\n"
                + "    (4) Edit first name\n"
                + "    (5) Edit date of birth\n"
                + "    (x) (Cancel)");
        switch (scan.nextLine()) {
            case "1":
                new AddStudent(student).add();
                new MainMenu().promptEnter();
                break;
            case "2":
                student.setStudentID(null);
                add();
                break;
            case "3":
                student.setSurname(null);
                add();
                break;
            case "4":
                student.setFirstName(null);
                add();
                break;
            case "5":
                student.setDateOfBirth(null);
                add();
                break;
            case "x":
                cancel();
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }
}
