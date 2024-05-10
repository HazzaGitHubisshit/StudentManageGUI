package infosys;

// Accessed through the AccessInformation UI.

public class ViewPaper {

    public void view() {
        Paper paper = new FindPaper().find();
        if (paper != null) {
            paper.paperInfo();
            new MainMenu().promptEnter();
        } else {
            new AccessInformation().access();
        }
    }
}
