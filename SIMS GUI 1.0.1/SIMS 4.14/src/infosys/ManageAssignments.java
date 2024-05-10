package infosys;

import java.util.ArrayList;

public class ManageAssignments {

    private static ArrayList<Assignment> assignments = new ArrayList<>();

    public void add(Assignment assignment) {
        assignments.add(assignment);
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public String standardLine(Assignment assignment) {
        return assignment.getPaperCode();
    }

    public void delete(Assignment assignment) {
        assignments.remove(assignment);
    }

    // Print assignments for a given student
    public void printAssignments(Student student) {
        ArrayList<Assignment> foundPapers = new ArrayList<>();

        // Find assignments
        for (Assignment assignment : assignments) {
            if (assignment.getStudentID().equals(student.getStudentID())) {
                foundPapers.add(assignment);
            }
        }
        // It only prints if papers are found; otherwise it does nothing
        if (!foundPapers.isEmpty()) {
            System.out.println("Papers for " + student.getFullName() + ":");
        }
        for (Assignment assignment : foundPapers) {
            System.out.println("    " + assignment.getPaper().standardLine()
                    + ", Semester "
                    + assignment.getSemester()
                    + " " + assignment.getYear()
                    + ", grade: " + assignment.getGrade());
        }
    }
}
