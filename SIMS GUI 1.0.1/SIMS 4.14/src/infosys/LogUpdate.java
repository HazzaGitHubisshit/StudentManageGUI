package infosys;

import java.time.LocalTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
This class writes an update to update_log.txt. The file lists a record of 
changes to the database committed by the user. At this point it's only called
by the Add and Delete classes. The calling method provides the relevant line to
write.
 */
public class LogUpdate {

    private String line;

    public LogUpdate(String line) {
        this.line = line;
    }

    public void log() {
        LocalTime time = LocalTime.now();
        String logLine = "\n" + time + ": " + line;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/update_log.txt", true))) {
            writer.write(logLine);
        } catch (IOException e) {
            System.out.println("I/O exception error when writing update to update_log.txt.\n");
        }
    }
}
