package infosys;

import java.util.ArrayList;

public class ReadPapers {

    private ArrayList<String> lines = new ArrayList<>();
    String filepath;

    public ReadPapers(String filepath) {
        this.filepath = filepath;
    }

    public void read() {
        lines = new ReadFile(filepath).getLines();
        parse();
    }

    private void parse() {
        for (String line : lines) {
            ArrayList<String> paper = new ParseEntry(line).getFields();
            if (!line.equals("")) {
                new ReadPaper(paper).read();
            }
        }
    }
}
