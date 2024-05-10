package infosys;

/*
Parses the 'learning outcomes' field of the paper object from the entry line.
*/

import java.util.ArrayList;

public class ParseOutcomes {

    ArrayList<String> learningOutcomes;

    public ParseOutcomes(String unparsedOutcomes) {
        this.learningOutcomes = new ArrayList<>();
        String outcome = "";
        for (int i = 0; i < unparsedOutcomes.length(); i++) {
            switch (unparsedOutcomes.charAt(i)) {
                case '*':
                    learningOutcomes.add(outcome);
                    outcome = "";
                    break;
                default:
                    outcome += unparsedOutcomes.charAt(i);
            }
        }
    }
    public ArrayList<String> getOutcomes() {
        return learningOutcomes;
    }
}
