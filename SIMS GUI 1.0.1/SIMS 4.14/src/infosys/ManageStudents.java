package infosys;

/*
The static ArrayList represents the 'official' database. It should be
consistent with the file database at all times.
 */
import java.util.ArrayList;

public class ManageStudents {

    private static final ArrayList<Student> students = new ArrayList<>();

    // Do not allow invalid IDs to enter the database.
    public void add(Student student) {
        if (student.getStudentID() != null) {
            students.add(student);
        } else {
            System.out.println("Failed to add student: invalid ID.");
        }
    }

    public Student getStudentFromID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void list() {
        for (Student student : students) {
            System.out.println("    " + student.standardLine());
        }
    }
}
