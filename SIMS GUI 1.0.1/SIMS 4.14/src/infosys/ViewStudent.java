package infosys;

// Accessed through the AccessInformation UI.

public class ViewStudent {
    public void view() {
        Student student = new FindStudent().find();
        if (student
                != null) {
            System.out.println(student.studentInfo());
            new ManageAssignments().printAssignments(student);
            new MainMenu().promptEnter(); // return to main menu
        } else {
            new AccessInformation().access(); // cancelled: go back to previous menu
        }
    }
}
