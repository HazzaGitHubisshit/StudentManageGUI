package infosys;

/*
This class prompts the user to choose a student, making use of the chooseEntry
class.
*/

import java.util.Scanner;

public class FindStudent {

    Scanner scan = new Scanner(System.in);
    Matches matches;

    public Student find() {
        System.out.println("Please enter a name or student ID.");
        String query = scan.nextLine();
        if (query.equals("x")) {
            return null;
        } else {
            matches = new Matches(new ManageStudents().getStudents(), query);
            if (!matches.isEmpty()) {
                Student student = (Student) new ChooseEntry(matches).choose();
                if (student != null) {
                    return student;
                } else {
                    return null;
                }
            } else {
                System.out.println("No students found!");
                return find();
            }
        }
    }
}
