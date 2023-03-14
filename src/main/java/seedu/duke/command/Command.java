package seedu.duke.command;

import seedu.duke.CompanyList;
import seedu.duke.venue.VenueList;



public class Command {

    protected String commandType;

    public Command(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandType(){
        return commandType;
    }

    public void execute(CompanyList companyList) {}

    public void execute(VenueList venueList) {}
}

