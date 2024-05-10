package infosys;

public class AssignPaper {

    private Assignment assignment;

    public AssignPaper(Assignment assignment) {
        this.assignment = assignment;
    }

    public void add() {
        String entryLine = assignment.getEntry();
        new ManageAssignments().add(assignment);
        new WriteEntry("resources/assignments.txt", entryLine).write();
        System.out.println("Added paper: " + assignment.standardLine());
        new MainMenu().promptEnter();
    }
}
