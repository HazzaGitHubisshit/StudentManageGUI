package infosys;

/*
Similar to FindStudent, but it filters for Paper objects.
*/

import java.util.Scanner;

public class FindPaper {

    Scanner scan = new Scanner(System.in);
    Matches matches;

    public Paper find() {
        System.out.println("Please enter a paper code or title.");
        String query = scan.nextLine();
        if (query.equals("x")) {
            return null;
        } else {
            matches = new Matches(new ManagePapers().getPapers(), query);
            if (!matches.isEmpty()) {
                ChooseEntry chooseEntry = new ChooseEntry(matches);
                Paper paper = (Paper) chooseEntry.choose();
                if (paper != null) {
                    return paper;
                } else {
                    return null;
                }
            } else {
                System.out.println("No papers found!");
                return find();
            }
        }
    }

}
