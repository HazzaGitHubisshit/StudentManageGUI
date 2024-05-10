package infosys;

/*
Handles the deletion of a paper identified by the user.
 */
import java.util.Stack;

public class DeletePaper {

    private Paper paper;

    public DeletePaper(Paper paper) {
        this.paper = paper;
    }

    public void delete() {
        // Delete from text file
        String target = paper.getPaperCode() + "|";
        new DeleteEntry("resources/papers.txt", target).delete();

        // Update log
        String logLine = "Deleted paper with the following paper code: " + target;
        new LogUpdate(logLine).log();

        // Delete orphaned assignment
        Stack<Assignment> orphans = new Stack<>();
        for (Assignment assignment : new ManageAssignments().getAssignments()) {
            if (assignment.getPaperCode().equals(paper.getPaperCode())) {
                orphans.push(assignment);
            }
        }
        new DeleteOrphans(orphans).delete();

        // Delete from memory
        new ManagePapers().delete(paper);
        System.out.println("Deleted paper: " + paper.standardLine());

        // Return to main menu
        new MainMenu().promptEnter();
    }
}
