package infosys;

import java.util.Scanner;

/*
Prompts the user to identify a paper for deletion.
*/

public class DeletePaperUI {

    private Paper paper;

    public void delete() {
        paper = new FindPaper().find();
        if (paper != null) {
            confirm();
        } else {
            System.out.println("Delete paper cancelled.");
            new UpdateInformation().update();
        }
    }

    public void confirm() {
        System.out.println("Are you sure you wish delete " + paper.getPaperTitle() + "?\n"
                + "    (1) Confirm\n"
                + "    (2) Cancel");
        Scanner scan = new Scanner(System.in);
        String choose = scan.nextLine();
        switch (choose) {
            case "1":
                new DeletePaper(paper).delete();
                break;
            case "2":
            case "x":
                new UpdateInformation().update();
                break;
            default:
                System.out.println("Invalid input.");
                confirm();
        }
    }
}
