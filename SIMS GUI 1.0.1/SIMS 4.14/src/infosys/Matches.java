package infosys;

/*
Provides a list of Entry objects that match a query passed by the user.
It could return students or papers. The methods that call it filter for one or the other as needed.
It's called by FindStudent and FindPaper.
*/

import java.util.ArrayList;

public class Matches {

    private ArrayList<Entry> matches;

    // Find all of the entries matching the query
    public Matches(ArrayList<? extends Entry> list, String query) {
        this.matches = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Entry entry : list) {
                if (entry.match(query)) {
                    matches.add(entry);
                }
            }
        }
    }
    
    public Matches(Matches matches) {
        this.matches.addAll(matches.matches);
    }
    
    public int getSize() {
        return matches.size();
    }

    public void listEntries() {
        for (int i = 0; i < matches.size(); i++) {
            System.out.println("    (" + (i + 1) + ") " + matches.get(i).standardLine());
        }
    }
    
    public boolean isEmpty() {
        return matches.isEmpty();
    }
    
    // Return the relevant entry
    public Entry getEntry(int index) {
        return matches.get(index);
    }            
}
