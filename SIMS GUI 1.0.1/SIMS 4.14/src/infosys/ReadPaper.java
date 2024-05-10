package infosys;

import java.util.ArrayList;

public class ReadPaper {

    private Paper paper;
    private ArrayList<String> paperUnparsed;

    public ReadPaper(ArrayList<String> paperUnparsed) {
        this.paperUnparsed = paperUnparsed;
        this.paper = new Paper(null, null, 0, 0, null);
    }

    public void read() {
        String paperCode = this.paperUnparsed.get(0);
        String paperTitle = this.paperUnparsed.get(1);
        String level = this.paperUnparsed.get(2);
        String points = this.paperUnparsed.get(3);
        String learningOutcomes = this.paperUnparsed.get(4);

        // Validate paper code
        if (new PaperCode(paperCode).toString() != null) {
            paper.setPaperCode(paperCode);
        } else {
            System.out.println("Paper entry line failed to parse: invalid paper code.\n");
            System.out.println("Error took place on line with paper code: " + paperCode);
            System.exit(0);
        }

        // Validate paper title
        if (new ValidateField(paperTitle).valid()) {
            paper.setPaperTitle(paperTitle);
        } else {
            System.out.println("Paper entry line failed to parse: invalid paper title.\n");
            System.out.println("Error took place on line with paper code: " + paperCode);
            System.exit(0);
        }

        // Validate level
        try {
            paper.setLevel(Integer.parseInt(level));
        } catch (NumberFormatException e) {
            System.out.println("Paper entry line failed to parse: level failed to parse.\n");
            System.out.println("Error took place on line with paper code: " + paperCode);
            System.exit(0);
        }

        // Validate points
        try {
            paper.setPoints(Integer.parseInt(points));
        } catch (NumberFormatException e) {
            System.out.println("Paper entry line failed to parse: points failed to parse.\n");
            System.out.println("Error took place on line with paper code: " + paperCode);
            System.exit(0);
        }

        // Parse learning outcomes
        ArrayList<String> outcomes = new ParseOutcomes(learningOutcomes).getOutcomes();
        paper.setOutcomes(outcomes);
        add();
    }

    public void add() {
        new ManagePapers().add(paper);
    }
}
