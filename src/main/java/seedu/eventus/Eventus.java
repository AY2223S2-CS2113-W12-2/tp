package seedu.eventus;

import seedu.eventus.command.Command;
import seedu.eventus.company.CompanyList;
import seedu.eventus.venue.VenueList;

import java.util.Scanner;

public class Eventus {

    private static VenueList venueList;
    private static CompanyList companyList;
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.showWelcome();
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        CompanyList companyList = new CompanyList();
        VenueList venueList = new VenueList(Storage.venueListInit());
        if (input.equals("bye")) {
            Ui.showExitMessage();
        } else {
            System.out.println("Unknown input");
        }
    }

    private static void run(String input) {
        Command command = Parser.parse(input);
    }
}
