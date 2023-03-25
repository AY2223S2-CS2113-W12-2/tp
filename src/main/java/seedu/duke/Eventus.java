package seedu.duke;

import seedu.duke.company.CompanyList;
import seedu.duke.data.VenueListData;
import seedu.duke.event.Event;
import seedu.duke.parser.Parser;
import seedu.duke.storage.CompanyListDecoder;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.command.Command;
import seedu.duke.venue.VenueList;
import seedu.duke.exception.WrongFormatException;

import java.util.ArrayList;
import java.util.Scanner;

public class Eventus {
    private Storage storage;
    private CompanyList companyList;
    private VenueList venueList;
    private Event event;
    private Ui ui;

    public Eventus() {
        storage = new Storage();
        ui = new Ui();
        companyList = new CompanyList(new ArrayList<>(), ui);
        event = new Event(companyList, ui);
        venueList = new VenueList(VenueListData.returnVenueList(), ui);
        run();
    }

    public void run() {
        ui.showWelcome();
        loadSavedInformation();
        String input;
        Scanner in = new Scanner(System.in);
        while (true) {
            input = in.nextLine();
            try {
                Command c = Parser.parse(input);
                if (c.getCommandType().equals("list venues")){
                    c.execute(venueList);
                } else if (c.getCommandType().equals("choose venue")){
                    c.execute(event, venueList);
                } else {
                    c.execute(companyList);
                }
            } catch (WrongFormatException | NullPointerException | IndexOutOfBoundsException err){
                System.out.println("Wrong Format! Please type <help> for more information");
            } catch (NumberFormatException err){
                System.out.println("Number expected! Please type <help> for more information");
            }
        }
    }

    public void loadSavedInformation() {
        CompanyListDecoder.read(companyList);
    }

    public static void main(String[] args) {
        new Eventus();
    }
}
