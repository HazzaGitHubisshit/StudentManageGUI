package Model;

import java.util.ArrayList;

public class Paper implements Entry {

    private PaperCode paperCode;
    private String paperTitle;
    private int level;
    private int points;
    private ArrayList<String> learningOutcomes;

    @Override
    public boolean match(String query) {
        return getPaperCode().toLowerCase().contains(query.toLowerCase())
                || getPaperTitle().toLowerCase().contains(query);
    }

    @Override
    public String standardLine() {
        return paperCode + " " + paperTitle;
    }
    
    public Paper(String paperCode, String paperTitle, int level, int points, ArrayList<String> learningOutcomes) {
        this.paperCode = new PaperCode(paperCode);
        this.paperTitle = paperTitle;
        this.level = level;
        this.points = points;
        this.learningOutcomes = learningOutcomes;
    }
    
    public String getPaperCode() {
        return paperCode.toString();
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = new PaperCode(paperCode);
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private void listLearningOutcomes() {
        for (String learningOutcome : getOutcomes()) {
            System.out.println("    " + learningOutcome);
        }
    }

    public void paperInfo() {
        System.out.println(
                "Paper title: " + this.paperTitle
                + "\nPaper code: " + this.paperCode
                + "\nLevel:  " + this.level
                + "\nPoints: " + this.points
                        + "\n\nLearning outcomes:");
        this.listLearningOutcomes();
    }

    public ArrayList<String> getOutcomes() {
        return learningOutcomes;
    }

    // For constructing the entry line
    public String getOutcomesLine() {
        String outcomes = "";
        for (int i = 0; i < learningOutcomes.size(); i++) {
            outcomes += learningOutcomes.get(i);
            if (i + 1 != learningOutcomes.size()) {
                outcomes += "*";
            }
        }
        outcomes += "|";
        return outcomes;
    }

    public void setOutcomes(ArrayList<String> learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }
}
