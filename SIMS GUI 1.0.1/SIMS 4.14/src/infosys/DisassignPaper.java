package infosys;

public class DisassignPaper {

    private Assignment assignment;

    public DisassignPaper(Assignment assignment) {
        this.assignment = assignment;
    }

    public void delete() {
        String target = assignment.getEntry();
        // use the whole entry line because two assignments can share the same paper code and ID combination

        new DeleteEntry("resources/assignments.txt", target).delete();

        String logLine = "Deleted assignment with the following paper code and student ID: " + target;
        new LogUpdate(logLine).log();

        new ManageAssignments().delete(assignment);
        System.out.println("Deleted assignment: " + assignment.assignmentInfo());

        new MainMenu().promptEnter();
    }
}
