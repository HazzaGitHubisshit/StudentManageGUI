package infosys;

/*
Read student entries of student.txt to memory.
*/

import java.util.ArrayList;

public class ReadStudents {

    private ArrayList<String> lines = new ArrayList<>();
    String filepath;

    public ReadStudents(String filepath) {
        this.filepath = filepath;
    }

    // Use ReadFile to construct a list of unparsed entries.
    public void read() {
        lines = new ReadFile(filepath).getLines();
        parse();
    }

    private void parse() {
        for (String line : lines) {
            ArrayList<String> student = new ParseEntry(line).getFields();
            if (!line.equals("")) {
                new ReadStudent(student).read();
            }
        }
    }
}
