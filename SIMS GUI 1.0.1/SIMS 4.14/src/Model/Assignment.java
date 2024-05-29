package Model;

import Model.Student;
import Model.Paper;

/*
This is an association class that models relationships between students and
papers.
 */
public class Assignment {

    private Paper paper;
    private Student student;
    private String grade;
    private int year;
    private int semester;

    public Assignment(Paper paper, Student student, String grade, int semester, int year) {
        this.paper = paper;
        this.student = student;
        this.grade = grade;
        this.year = year;
        this.semester = semester;
    }

    public String assignmentInfo() {
        return student.standardLine() + "\n"
                + paper.standardLine() + "\n"
                + "\nGrade: " + this.getGrade()
                + "\nYear: " + this.getYear()
                + "\nSemester: " + this.getSemester();
    }

    public String standardLine() {
        return paper.getPaperCode() + " "
                + student.getFullName() + " "
                + this.year + ", semester " + this.semester;
    }
    
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Paper getPaper() {
        return this.paper;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPaperCode() {
        return this.paper.getPaperCode();
    }

    public String getGrade() {
        if (grade==null) {
            return null;
        }
        return this.grade;
    }

    public String getStudentID() {
        return this.student.getStudentID();
    }

    public int getSemester() {
        return this.semester;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public String getEntry() {
        return this.getPaperCode() + "|" + this.getStudentID() + "|" + this.getGrade() + "|" + this.getYear() + "|" + this.getSemester() + "|";
    }
}
