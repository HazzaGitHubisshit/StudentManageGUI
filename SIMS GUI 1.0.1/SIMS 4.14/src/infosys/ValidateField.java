package infosys;

/*
This class validates fields passed by the user or read from a file.
*/

public class ValidateField {

    private String field;

    public ValidateField(String field) {
        this.field = field;
    }

    public boolean valid() {
        // This method tells us if the input is valid. It has to pass a few rules.
        return (!(field.contains("|") 
                || field.contains("*") 
                || field.equals("null") 
                || field.isEmpty()));
    }
}
