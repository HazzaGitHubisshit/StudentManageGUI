package infosys;

// Format: Paper code|Student ID|Grade|Year|Semester|
import java.util.ArrayList;

public class ReadAssignments {

    private ArrayList<String> lines = new ArrayList<>();
    String filepath;

    public ReadAssignments(String filepath) {
        this.filepath = filepath;
    }

    public void read() {
        lines = new ReadFile(filepath).getLines();
        parse();
    }

    private void parse() {
        for (String line : lines) {
            ArrayList<String> assignment = new ParseEntry(line).getFields();
            if (!line.equals("")) {
                new ReadAssignment(assignment).read();
            }
        }
    }
}
