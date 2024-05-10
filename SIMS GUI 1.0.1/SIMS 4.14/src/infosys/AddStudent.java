package infosys;

public class AddStudent {

    private Student student;

    public AddStudent(Student student) {
        this.student = student;
    }

    public void add() {
        String entryLine = student.getStudentID() + "|"
                + student.getSurname() + "|"
                + student.getFirstName() + "|"
                + student.getDateOfBirth() + "|";
        new ManageStudents().add(student);
        new WriteEntry("resources/students.txt", entryLine).write();
        System.out.println("Added student: " + student.standardLine());
        new MainMenu().promptEnter();
    }
}
