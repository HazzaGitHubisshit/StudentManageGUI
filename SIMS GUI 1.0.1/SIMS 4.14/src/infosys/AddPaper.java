package infosys;

/*
Adds a paper constructed by the user.
*/

public class AddPaper {

    private Paper paper;

    public AddPaper(Paper paper) {
        this.paper = paper;
    }

    public void add() {
        String entryLine = paper.getPaperCode() + "|" + paper.getPaperTitle() + "|" + paper.getLevel() + "|" + paper.getPoints() + "|" + paper.getOutcomesLine(); // construct entry line
        new ManagePapers().add(paper); // add paper to static array
        new WriteEntry("resources/papers.txt", entryLine).write(); // write entry to papers.txt
        System.out.println("Added paper: " + paper.standardLine());
        new MainMenu().promptEnter(); // return to main menu
    }
}
