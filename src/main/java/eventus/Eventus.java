package eventus;

import eventus.command.Command;
import eventus.company.CompanyList;
import eventus.venue.VenueList;

import java.util.Scanner;

public class Eventus {

    private static VenueList venueList;
    private static CompanyList companyList;
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.showWelcome();
        String input;
        Scanner in = new Scanner(System.in);
        CompanyList companyList = new CompanyList();
        VenueList venueList = new VenueList(Storage.venueListInit());
        do {
            input = in.nextLine();
            run(input);
        } while (!input.equals("bye"));
    }

    private static void run(String input) {
        Command command = Parser.parse(input);
    }
}
