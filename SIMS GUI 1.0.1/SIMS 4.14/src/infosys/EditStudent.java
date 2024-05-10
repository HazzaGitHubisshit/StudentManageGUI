package infosys;

// Similar to EditPaper.

import java.util.Scanner;

public class EditStudent {

    Scanner scan = new Scanner(System.in);

    Student student;

    public EditStudent(Student student) {
        this.student = student;
    }

    public Student setStudentID() {
        System.out.println("Please enter a valid student ID (must be unique, eight digits): ");
        String userInput = scan.nextLine();
        if (userInput.equals("x")) {
            return null;
        }
        if (new StudentID(userInput).toString()!=null) {
            student.setStudentID(userInput);
            System.out.println("Student ID validated");
            return student;
        } else {
            System.out.println("Invalid input.");
            return setStudentID();
        }
    }

    public Student setSurname() {
        System.out.println("Please enter a valid surname: ");
        String userInput = scan.nextLine();
        if (userInput.equals("x")) {
            return null;
        }
        if (new ValidateField(userInput).valid()) {
            student.setSurname(userInput);
            System.out.println("Surname validated");
            return student;
        } else {
            System.out.println("Invalid input.");
            return setSurname();
        }
    }

    public Student setFirstName() {
        System.out.println("Please enter a valid first name: ");
        String userInput = scan.nextLine();
        if (userInput.equals("x")) {
            return null;
        }
        if (new ValidateField(userInput).valid()) {
            student.setFirstName(userInput);
            System.out.println("First name validated");
            return student;
        } else {
            System.out.println("Invalid input.");
            return setFirstName();
        }
    }

    public Student setDateOfBirth() {
        int day = 0;
        int month = 0;
        int year = 0;
        System.out.println("Enter day: ");
        String input = scan.nextLine();
        if (input.equals("x")) {
            return null;
        }
        try {
            day = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter only valid integers.");
            setDateOfBirth();
        }

        System.out.println("Enter month: ");
        input = scan.nextLine();
        if (input.equals("x")) {
            return null;
        }
        try {
            month = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter only valid integers.");
            setDateOfBirth();
        }

        System.out.println("Enter year: ");
        input = scan.nextLine();
        if (input.equals("x")) {
            return null;
        }
        try {
            year = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter only valid integers.");
            setDateOfBirth();
        }

        Date date = new Date(day, month, year);
        if (!date.validDate()) {
            System.out.println("Invalid date.");
            return setDateOfBirth();
        }

        student.setDateOfBirth(date);
        return student;
    }
}
