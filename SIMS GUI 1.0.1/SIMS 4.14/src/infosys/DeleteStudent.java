package infosys;

/*
The delete methods manage two tasks associated with deletion. First, they
delete the data from the runtime memory. Second, they alter the database
represented in the relevant text file. They also call LogUpdate with a line
describing the change that took place.
 */
import java.util.Stack;

public class DeleteStudent {

    private Student student;
    private String studentID;

    public DeleteStudent(Student student) {
        this.student = student;
        this.studentID = student.getStudentID();
    }

    public void delete() {
        String target = studentID + "|";

        new DeleteEntry("resources/students.txt", target).delete();

        String logLine = "Deleted student with the following ID: " + studentID;
        new LogUpdate(logLine).log();

        Stack<Assignment> orphans = new Stack<>();
        for (Assignment assignment : new ManageAssignments().getAssignments()) {
            if (assignment.getStudent().getStudentID().equals(studentID)) {
                orphans.push(assignment);
            }
        }
        new DeleteOrphans(orphans).delete();

        new ManageStudents().deleteStudent(student);
        System.out.println("Deleted student: " + student.standardLine());
        new MainMenu().promptEnter();
    }
}
