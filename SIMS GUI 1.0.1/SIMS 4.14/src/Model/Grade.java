package Model;

public class Grade {

    private static final String[] grades = {
        "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "W", "S", "Cr", "DS", "CO", "DNC", "M", "P", "F", "STC", "UX"
    };

    // called by ReadAssignment
    public boolean valid(String input) {
        for (String grade : grades) {
            if (grade.equals(input)) {
                return true;
            }
        }
        return false;
    }
    
    // called by AssignPaperUI
    public String[] getGrades() {
        return grades;
    }
}
