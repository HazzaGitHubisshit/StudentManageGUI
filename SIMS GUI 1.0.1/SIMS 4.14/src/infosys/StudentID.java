package infosys;

/*
It's important that IDs are entirely unique and have entirely uniform 
formatting. A separate class for IDs allows us  more control over IDs, which 
defends against conflation. For instance, if the  ID did not have a fixed 
number of digits, the system may mistake '123456' for '456'.

A value of null represents an invalid ID. In case any bad values slip through 
the cracks, ManageStudents refuses to add any student with an invalid (null) ID 
to the static ArrayList. Ensure validity tests before passing IDs.
 */

public class StudentID {

    public String studentID;

    public StudentID(String studentID) {
        // An ID can't be null.
        if (studentID != null) {
            // Every ID must be exactly eight characters for uniformity in formatting.
            if (studentID.length() == 8) {
                try {
                    // The ID must consist of only numerical characters.
                    int test = Integer.parseInt(studentID);
                    this.studentID = studentID;
                    // The ID is tested for uniqueness: all IDs must be unique.
                    for (Student student : new ManageStudents().getStudents()) {
                        if (student.getStudentID().equals(studentID)) {
                            this.studentID = null;
                        }
                    }
                } catch (NumberFormatException e) {
                    this.studentID = null;
                }
            } else {
                this.studentID = null;
            }
        } else {
            this.studentID = null;
        }
        // The variable is set to null if the ID fails verification. A null 'studentID' indicates an invalid ID.
    }

    @Override
    public String toString() {
        return studentID;
    }
}
