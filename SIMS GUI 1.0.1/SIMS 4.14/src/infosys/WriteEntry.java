package infosys;

/*
This class writes an entry line to any of the three tables.
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEntry {

    String filepath;
    String entryLine;

    // Invoke the object with the relevant filepath and the already-constructed line
    public WriteEntry(String filepath, String entryLine) {
        this.filepath = filepath;
        this.entryLine = entryLine;
    }

    public void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            writer.newLine();
            writer.write(entryLine);
        } catch (IOException e) {
            System.out.println("I/O exception error when writing entry to " + filepath);
            System.exit(0);
        }
        
        // Write line to the update log
        String logLine = "Added entry to " + filepath + " with the following entry line: " + entryLine;
        new LogUpdate(logLine).log();
    }
}
