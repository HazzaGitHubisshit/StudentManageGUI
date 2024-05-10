package infosys;

/*
Used to select an entry object from a list of matches to the query entered by
the user.
*/

import java.util.Scanner;

public class ChooseEntry {

    Matches matches;
    Scanner scan = new Scanner(System.in);

    public ChooseEntry(Matches matches) {
        this.matches = matches;
    }

    public Entry choose() {
        if (!matches.isEmpty() && matches.getSize() == 1) {
            System.out.println("We found: " + matches.getEntry(0).standardLine());
            System.out.println("Is this the entry you were looking for?\n"
                    + "    (1) Yes\n"
                    + "    (2) No\n"
                    + "    (x) (Go back)");
            String choose = scan.nextLine();
            switch (choose) {
                case "x":
                    return null;
                case "1":
                    return matches.getEntry(0);
                case "2":
                    return null;
                default:
                    System.out.println("Invalid input. Please choose from the options provided.");
                    return choose();
            }
        } else if (!matches.isEmpty()) {
            System.out.println("We found the following entries. Please enter the number for the correct entry.");
            matches.listEntries();
            System.out.println("    (x) (Go back)");
            String choose = scan.nextLine();
            if (!choose.equals("x")) {
                try {
                    int index = Integer.parseInt(choose);
                    if (index > 0 && index <= matches.getSize()) {
                        index--;
                        return matches.getEntry(index);
                    } else {
                        System.out.println("Invalid input. Please choose from the options provided.");
                        return choose();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please choose from the options provided.");
                    return choose();
                }
            } else {
                return null; // the user cancelled: exit loop
            }
        }
        System.out.println("No entries were found. Please enter a valid query.");
        return choose();
    }
}
