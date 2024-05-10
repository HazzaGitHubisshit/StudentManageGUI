package infosys;

/*
The Entry interface allows us to implement classes that offer common uses for
both the Student and Paper classes.
*/

public interface Entry {
    boolean match(String query);
    String standardLine();
}
