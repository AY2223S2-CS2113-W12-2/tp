package eventus.command;

import eventus.venue.VenueList;

public abstract class Command {

    protected String commandType;

    public Command(String commandType) {
        this.commandType = commandType;
    }
    public abstract void execute(VenueList venueList);
}

