package infosys;

/*
This class deletes a written entry line in a text file. A uniquely 
identifying 'target' should be passed to target the correct line for deletion.
This allows us to update the database according to the changes committed by the
user.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DeleteEntry {

    String filepath;
    String target;

    public DeleteEntry(String filepath, String target) {
        this.filepath = filepath;
        this.target = target;
    }

    public void delete() {

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath)); BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {

            String header = reader.readLine();
            writer.write(header);
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(target) // find targeted entry to delete
                        || line.trim().isEmpty()) { // clean empty lines
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
        }

        // Handle files
        try {
            Files.delete(Paths.get(filepath)); // delete old file copy
            Files.move(Paths.get("temp.txt"), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING); // replace the file
        } catch (IOException e) {
            System.out.println("Error deleting entry.");
        }
        
        System.out.println("Deleted entry: " + target);
    }
}
