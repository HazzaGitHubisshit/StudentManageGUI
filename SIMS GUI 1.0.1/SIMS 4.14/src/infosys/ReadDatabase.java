package infosys;

// Read the text file data to memory.

public class ReadDatabase {
    public void read() {
        new ReadStudents("resources/students.txt").read();
        new ReadPapers("resources/papers.txt").read();
        new ReadAssignments("resources/assignments.txt").read();
    }
}
