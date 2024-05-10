package infosys;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
It reads through each line of a file and returns the lines in as Strings in an
ArrayList. These lines are returned to the calling class and then passed to
ParseEntry.
*/

public class ReadFile {

    private String filepath;
    private ArrayList<String> lines;

    // Read all lines
    public ReadFile(String filepath) {
        this.lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) !=null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
            System.exit(0);
        }
    }
    
    // Return lines
    public ArrayList<String> getLines() {
        return this.lines;
    }
}
