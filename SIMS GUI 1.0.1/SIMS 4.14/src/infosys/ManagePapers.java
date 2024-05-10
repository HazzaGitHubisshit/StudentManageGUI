package infosys;

import java.util.ArrayList;

public class ManagePapers {

    private static ArrayList<Paper> papers = new ArrayList<>();

    public void add(Paper paper) {
        papers.add(paper);
    }

    public ArrayList<Paper> getPapers() {
        return papers;
    }

    public void list() {
        for (Paper paper : papers) {
            System.out.println("    " + paper.standardLine());
        }

    }

    public Paper getPaperFromCode(String paperCode) {
        for (Paper paper : papers) {
            if (paper.getPaperCode().equals(paperCode)) {
                return paper;
            }
        }
        return null;
    }

    public void delete(Paper paper) {
        papers.remove(paper);
    }

    public Paper getPaper(String paperCode) {
        for (Paper paper : papers) {
            if (paper.getPaperCode().equals(paperCode)) {
                return paper;
            }
        }
        return null;
    }

}
