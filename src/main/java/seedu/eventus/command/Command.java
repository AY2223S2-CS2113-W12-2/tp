package seedu.eventus.command;

import seedu.eventus.venue.VenueList;

public abstract class Command {

    protected String commandType;

    public Command(String commandType) {
        this.commandType = commandType;
    }
    public abstract void execute(VenueList venueList);
}

