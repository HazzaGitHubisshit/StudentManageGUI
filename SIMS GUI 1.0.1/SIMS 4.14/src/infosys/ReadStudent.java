package infosys;

/*
Reads a student entry to memory.
 */
import java.util.ArrayList;

public class ReadStudent {

    private Student student;
    private ArrayList<String> fields;

    public ReadStudent(ArrayList<String> fields) {
        this.fields = fields;
        this.student = new Student(null, null, null, null);
    }

    public void read() {

        String studentID = this.fields.get(0);
        String surname = this.fields.get(1);
        String firstName = this.fields.get(2);
        String dateOfBirth = this.fields.get(3);

        // Validate fields
        if (this.fields.size() != 4) {
            System.out.println("Student entry line failed to parse: invalid number of fields.\n");
            System.out.println("Error took place on line with ID: " + fields.get(0));
            System.exit(0);
        }

        // Validate student ID
        if (new StudentID(studentID).toString() != null) {
            student.setStudentID(studentID);
        } else {
            System.out.println("Student entry line failed to parse: invalid student ID.\n");
            System.out.println("Error took place on line with ID: " + studentID);
            System.exit(0);
        }

        // Validate surname
        if (new ValidateField(surname).valid()) {
            student.setSurname(surname);
        } else {
            System.out.println("Student entry line failed to parse: invalid surname.\n");
            System.out.println("Error took place on line with ID: " + studentID);
            System.exit(0);

        }

        // Validate first name
        if (new ValidateField(firstName).valid()) {
            student.setFirstName(firstName);
        } else {
            System.out.println("Student entry line failed to parse: invalid firstName.\n");
            System.out.println("Error took place on line with ID: " + studentID);
            System.exit(0);

        }
        // Validate date
        Date date = new ParseDate().parseDate(dateOfBirth);

        if (date == null || !date.validDate()) {
            System.out.println("Student entry line failed to parse: date of birth failed to parse.\n");
            System.out.println("Error took place on line with ID: " + studentID);
            System.exit(0);
        } else {
            student.setDateOfBirth(date);
        }

        new ManageStudents().add(student);
    }
}
