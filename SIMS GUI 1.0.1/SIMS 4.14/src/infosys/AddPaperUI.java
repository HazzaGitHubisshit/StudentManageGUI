package infosys;

/*
It follows similar principles to AddStudentUI.
*/

import java.util.Scanner;

public class AddPaperUI {

    private Paper paper;
    EditPaper edit;
    Scanner scan = new Scanner(System.in);

    public AddPaperUI() {
        // The method begins by initialising an incomplete paper instance.
        this.paper = new Paper(null, null, 0, 0, null);
        this.edit = new EditPaper(paper);
    }

    // The add() method iterates through each field and calls edit to prompt the user to fill in any empty fields.
    public void add() {
        if (paper != null) {
            if (paper.getPaperCode() == null) {
                paper = edit.setPaperCode();
                add();
            } else if (paper.getPaperTitle() == null) {
                paper = edit.setPaperTitle();
                add();
            } else if (paper.getLevel() == 0) {
                paper = edit.setLevel();
                add();
            } else if (paper.getPoints() == 0) {
                paper = edit.setPoints();
                add();
            } else if (paper.getOutcomes() == null) {
                paper = edit.setOutcomes();
                add();
            } else {
                confirm();
            }
        } else {
            cancel();
        }

    }

    // User cancels: return to previous menu
    public void cancel() {
        System.out.println("Cancelled add paper.");
        new UpdateInformation().update();
    }

    public void confirm() {
        System.out.println("Confirm and add to database?\n");
        paper.paperInfo();
        System.out.println("    (1) Confirm\n"
                + "    (2) Edit paper code\n"
                + "    (3) Edit paper title\n"
                + "    (4) Edit level\n"
                + "    (5) Edit points\n"
                + "    (6) Edit learning outcomes\n"
                + "    (x) Cancel");

        switch (scan.nextLine()) {
            case "1":
                new AddPaper(paper).add();
                break;
            case "2":
                paper.setPaperCode(null);
                add();
                break;
            case "3":
                paper.setPaperTitle(null);
                add();
                break;
            case "4":
                paper.setLevel(0);
                add();
                break;
            case "5":
                paper.setPoints(0);
                add();
                break;
            case "6":
                paper.setOutcomes(null);
                add();
                break;
            case "x":
                cancel();
                break;
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }
}
