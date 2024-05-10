package infosys;

/*
Provides methods for constructing or editing a Paper object. EditStudent
follows similar principles. These classes could also be adapted for an option
for updating or an editing an already-existing paper or student entry.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class EditPaper {

    Scanner scan = new Scanner(System.in);
    Paper paper;

    public EditPaper(Paper paper) {
        this.paper = paper;
    }

    public Paper setPaperCode() {
        System.out.println("Please enter a valid paper code (unique, eight digits).");
        String input = scan.nextLine();
        if (input.equals("x")) {
            return null;
        } else {
            if (new PaperCode(input).toString() != null) {
                paper.setPaperCode(input);
                return paper;
            } else {
                System.out.println("Invalid paper code.");
                return setPaperCode();
            }
        }
    }

    public Paper setPaperTitle() {
        System.out.println("Please enter a valid paper title.");
        String input = scan.nextLine();
        if (input.equals("x")) {
            return null;
        } else {
            if (new ValidateField(input).valid()) {
                System.out.println("Paper title validated.");
                paper.setPaperTitle(input);
                return paper;
            } else {
                System.out.println("Invalid paper title.");
                return setPaperTitle();
            }
        }
    }

    public Paper setLevel() {
        System.out.println("Please enter a valid paper level.");
        String input = scan.nextLine();
        try {
            int level = Integer.parseInt(input);
            if (level < 5 || level > 8) {
                System.out.println("Invalid paper level.");
                return setLevel();
            } else {
                paper.setLevel(level);
                System.out.println("Paper level validated.");
                return paper;
            }
        } catch (NumberFormatException e) {
            if (input.equals("x")) {
                return null;
            } else {
                System.out.println("Invalid paper level.");
                return setLevel();
            }
        }
    }

    public Paper setPoints() {
        System.out.println("Please enter the paper points.");
        String input = scan.nextLine();
        try {
            int points = Integer.parseInt(input);
            if (points < 1 || points > 15) {
                System.out.println("Invalid paper points.");
                return setPoints();
            } else {
                System.out.println("Paper points validated.");
                paper.setPoints(points);
                return paper;
            }
        } catch (NumberFormatException e) {
            if (input.equals("x")) {
                return null;
            } else {
                System.out.println("Invalid paper points.");
                return setPoints();
            }
        }
    }

    public Paper setOutcomes() {
        ArrayList<String> outcomes = new ArrayList<>();
        while (true) {
            System.out.println("Enter outcome ('x' to complete): ");
            String input = scan.nextLine();
            if (input.equals("x")) {
                break;
            } else if (new ValidateField(input).valid()) {
                System.out.println("Added outcome.");
                outcomes.add(input);
            } else {
                System.out.println("Invalid output.");
            }
        }
        if (outcomes.isEmpty()) {
            return null;
        }
        paper.setOutcomes(outcomes);
        return paper;
    }

}
