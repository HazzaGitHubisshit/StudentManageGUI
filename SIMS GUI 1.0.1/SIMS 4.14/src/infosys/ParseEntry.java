package infosys;

import java.util.ArrayList;

/*
It takes an entry line and breaks it down into its component fields.
This is really bad way of handling file I/O--but it is what it is!
*/

public class ParseEntry {

    private ArrayList<String> fields;

    public ParseEntry(String line) {
        this.fields = new ArrayList<>();
        String field = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '|') { // The '|' character separates the fields.
                fields.add(field); // add completed field
                field = ""; // new field
            } else {
                field += line.charAt(i);
            }
        }
    }

    public ArrayList<String> getFields() {
        return this.fields;
    }
}
