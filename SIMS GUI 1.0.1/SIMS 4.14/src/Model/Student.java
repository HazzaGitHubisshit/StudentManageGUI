package Model;

public class Student implements Entry {

    private StudentID studentID;
    private String surname;
    private String firstName;
    private Date dateOfBirth;

    public Student(String studentID, String surname, String firstName, Date dateOfBirth) {
        this.studentID = new StudentID(studentID);
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean match(String query) {
        return getFullName().toLowerCase().contains(query.toLowerCase())
                || getStudentID().contains(query);
    }

    @Override
    public String standardLine() {
        return this.studentID + ": " + getFullName();
    }

    // Getters and setters
    
    public String getStudentID() {
        return this.studentID.toString();
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {
        return this.firstName + " " + this.surname;
    }

    public String getDateOfBirth() {
        if (dateOfBirth == null) {
            return null;
        }
        return this.dateOfBirth.toString();
    }

    public String studentInfo() {
        return "Name: " + getFullName()
                + "\nStudent ID: " + studentID
                + "\nDate of birth: " + getDateOfBirth();
    }

    public void setStudentID(String studentID) {
        this.studentID = new StudentID(studentID);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
