package infosys;

/*
Prompts the user to remove a paper assigned to a student, i.e. delete an
Assignment.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class DisassignPaperUI {

    private Student student;
    private Assignment assignment;
    private Scanner scan = new Scanner(System.in);

    public void disassign() {
        student = new FindStudent().find();
        if (student == null) {
            cancel();
        } else {
            setPaper();
        }
    }

    public void setPaper() {
        ArrayList<Assignment> found = new ArrayList<>();
        for (Assignment assignment : new ManageAssignments().getAssignments()) {
            if (assignment.getStudentID().equals(student.getStudentID())) {
                found.add(assignment);
            }
        }
        if (found.isEmpty()) {
            System.out.println("No papers found for this student!");
            new UpdateInformation().update();
        } else {
            System.out.println("Choose the paper to disassign.");
            for (int i = 0; i < found.size(); i++) {
                System.out.println("    (" + (i + 1) + ") " + found.get(i).standardLine() + ", Year " + found.get(i).getYear() + ", Semester " + found.get(i).getSemester());
            }
            System.out.println("    (x) (Cancel)");
            String input = scan.nextLine();
            try {
                int choose = Integer.parseInt(input);
                choose--; // adjust for indexing
                if (choose < 0 || choose > found.size()) {
                    System.out.println("Invalid input. Please choose from the options provided.");
                    setPaper();
                } else {
                    assignment = found.get(choose);
                    confirm();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose from the options provided.");
                setPaper();
            }
        }
    }

    public void cancel() {
        System.out.println("Disassign paper cancelled.");
        new UpdateInformation().update();
    }

    public void confirm() {
        System.out.println("Remove " + assignment.getPaperCode() + " from student " + assignment.getStudentID() + "?\n"
                + "    (1) Confirm\n"
                + "    (2) Cancel");
        switch (scan.nextLine()) {
            case "1":
                new DisassignPaper(assignment).delete();
                new MainMenu().promptEnter();
            case "2":
            case "x":
                cancel();
                break;
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }

}
