package infosys;

/*
Prompts the user to assign an identified paper to an identified student and
provide necessary details.
 */
import java.time.Year;
import java.util.Scanner;

public class AssignPaperUI {

    private Scanner scan = new Scanner(System.in);
    private Assignment assignment = new Assignment(null, null, null, 0, 0);
    private Student student = null;
    private Paper paper = null;

    // assign() 'figures out' what the program needs to do next.
    public void assign() {
        if (assignment != null) { // a null assignment pointer indicates the user cancelled
            if (student == null) {
                setStudent();
                assign();
            } else if (paper == null) {
                setPaper();
                assign();
            } else if (assignment.getGrade() == null) {
                setGrade();
                assign();
            } else if (assignment.getYear() == 0) {
                setYear();
                assign();
            } else if (assignment.getSemester() == 0) {
                setSemester();
                assign();
            } else {
                confirm();
            }
        } else {
            cancel();
        }
    }

    public void setStudent() {
        student = new FindStudent().find();
        if (student == null) {
            assignment = null;
        } else {
            assignment.setStudent(student);
        }
        assign();
    }

    public void setPaper() {
        paper = new FindPaper().find();
        if (paper == null) {
            assignment = null;
        } else {
            assignment.setPaper(paper);
        }
        assign();
    }

    public void setYear() {
        System.out.println("Enter a year: ");
        String input = scan.nextLine();
        try {
            int year = Integer.parseInt(input);
            if (year - 1 > Year.now().getValue()) {
                System.out.println("Invalid input: can't assign papers this far in advance.");
            } else {
                System.out.println("Year validated.");
                assignment.setYear(year);
            }
        } catch (NumberFormatException e) {
            if (input.equals("x")) {
                assignment = null;
            } else {
                System.out.println("Invalid input: please enter an integer.");
            }
        }
        assign();
    }

    public void setSemester() {
        System.out.println("Enter a semester (1 or 2): ");
        String input = scan.nextLine();
        try {
            int semester = Integer.parseInt(input);
            if (semester < 0 || semester > 2) {
                System.out.println("Invalid input.");
            } else {
                System.out.println("Semester validated.");
                assignment.setSemester(semester);
            }

        } catch (NumberFormatException e) {
            if (input.equals("x")) {
                assignment = null;
            } else {
                System.out.println("Invalid input.");
            }
        }
        assign();
    }

    public void setGrade() {
        System.out.println("Select a grade.");
        String[] grades = new Grade().getGrades();
        for (int i = 1; i < grades.length; i++) {
            System.out.println("    (" + i + ") " + grades[i - 1]);
        }
        String input = scan.nextLine();
        try {
            int grade = Integer.parseInt(input);
            grade--; // adjust for indexing
            if (grade < 0 || grade > grades.length) {
                System.out.println("Invalid input");
            } else {
                assignment.setGrade(grades[grade]);
                System.out.println("Grade validated");
            }

        } catch (NumberFormatException e) {
            if (input.equals("x")) {
                assignment = null;
            } else {
                System.out.println("Invalid input.");
            }
        }
        assign();
    }

    // Confirm change
    public void confirm() {
        System.out.println(assignment.assignmentInfo());
        System.out.println("Confirm assignment?\n"
                + "    (1) Confirm\n"
                + "    (2) Change student \n"
                + "    (3) Change paper\n"
                + "    (4) Change grade\n"
                + "    (5) Change year\n"
                + "    (6) Change semester\n"
                + "    (x) Cancel");
        switch (scan.nextLine()) {
            case "1":
                new AssignPaper(assignment).add();
                break;
            case "2":
                student = null;
                assign();
                break;
            case "3":
                paper = null;
                assign();
                break;
            case "4":
                assignment.setGrade(null);
                assign();
                break;
            case "5":
                assignment.setYear(0);
                assign();
                break;
            case "6":
                assignment.setSemester(0);
                assign();
                break;
            case "x":
                cancel();
                break;
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }

    // User cancels: return to previous menu
    public void cancel() {
        System.out.println("Cancelled assign paper.");
        new UpdateInformation().update();
    }
}
