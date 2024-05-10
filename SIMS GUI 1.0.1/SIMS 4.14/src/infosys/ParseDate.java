package infosys;

/*
This is an abomination but it is what it is.
*/

import java.util.ArrayList;

public class ParseDate {

    public Date parseDate(String dateUnparsed) {
        ArrayList<String> values = new ArrayList<>();
        String value = "";
        for (int i = 0; i < dateUnparsed.length(); i++) {
            switch (dateUnparsed.charAt(i)) {
                case '/':
                    values.add(value);
                    value = "";
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    value += dateUnparsed.charAt(i);
                    break;
                default:
                    return null;
            }
        }
        values.add(value);
        
        // Test number of values
        if (values.size()!=3) {
            return null;
        }
        
        // Validate fields
        int day;
        int month;
        int year;
        try {
            day = Integer.parseInt(values.get(0));
            month = Integer.parseInt(values.get(1));
            year = Integer.parseInt(values.get(2));
            
        } catch (NumberFormatException e) {
            return null;
        }
        Date date = new Date(day, month, year);
        if (date.validDate()) {
            return date;
        }
        return null;
    }
}
