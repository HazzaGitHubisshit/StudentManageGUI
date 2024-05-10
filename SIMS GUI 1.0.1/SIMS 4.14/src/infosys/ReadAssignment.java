package infosys;

import java.time.Year;
import java.util.ArrayList;

public class ReadAssignment {

    private Assignment assignment;
    private ArrayList<String> fields;

    public ReadAssignment(ArrayList<String> fields) {
        this.fields = fields;
        this.assignment = new Assignment(null, null, null, 0, 0);
    }

    public void read() {
        String paperCode = this.fields.get(0);
        String studentID = this.fields.get(1);
        String grade = this.fields.get(2);
        String year = this.fields.get(3);
        String semester = this.fields.get(4);

        // Validate paper code
        ManagePapers managePapers = new ManagePapers();
        for (Paper paper : managePapers.getPapers()) {
            if (paperCode.equals(paper.getPaperCode())) {
                assignment.setPaper(managePapers.getPaperFromCode(paperCode));
            }
        }
        if (assignment.getPaper() == null) {
            System.out.println("Error in reading assignments.txt: invalid paper code.");
            System.exit(0);
        }

        // Validate ID
        ManageStudents manageStudents = new ManageStudents();
        for (Student student : manageStudents.getStudents()) {
            if (studentID.equals(student.getStudentID())) {
                assignment.setStudent(manageStudents.getStudentFromID(studentID));
            }
        }
        if (assignment.getStudent() == null) {
            System.out.println("Error in reading assignments.txt: invalid student ID.");
            System.exit(0);
        }

        // Validate grade
        if (new Grade().valid(grade)) {
            assignment.setGrade(grade);
        } else {
            System.out.println("Error in reading assignments.txt: invalid grade.");
            System.exit(0);
        }

        // Validate year
        try {
            int yearNo = Integer.parseInt(year);
            if (yearNo - 1 <= Year.now().getValue()) {
                assignment.setYear(yearNo);
            } else {
                System.out.println("");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in reading assignments.txt: invalid year (failed to parse to integer).");
        }

        // Validate semester
        try {
            int semesterNo = Integer.parseInt(semester);
            if (semesterNo == 1 || semesterNo == 2) {
                assignment.setSemester(semesterNo);
            } else {
                System.out.println("Error in reading assignments.txt: invalid semester (invalid number).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in reading assignments.txt: invalid semester (failed to parse to integer).");
        }

        add();

    }

    public void add() {
        new ManageAssignments().add(assignment);
    }
}
