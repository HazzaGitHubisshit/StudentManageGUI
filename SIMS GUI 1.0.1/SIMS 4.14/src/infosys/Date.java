package infosys;

/*
A simple date object with validation methods.
*/

import java.time.Year;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean validDate() {
        if (!validDay()) {
            return false;
        }
        if (month <1 || month > 12) {
            return false;
        }
        return year-1 <= Year.now().getValue();
        // We can add papers for the next year, but no further in the future than this. This is why we subtract one from year.
    }

    public boolean validDay() {
        if (day < 0 || day > 31) {
            return false;
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return day <= 31;
                case 4:
                case 6:
                case 9:
                case 11:
                    return day <= 30;
                case 2:
                    if (year % 4 == 0) {
                        return day <= 29;
                    }
                    return day <= 28;
                default:
                    return false;
            }
        }
    }
    
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
