package seedu.eventus.command;

import seedu.eventus.venue.VenueList;

public class ListVenueCommand extends Command{
    public ListVenueCommand(String commandType){
        super(commandType);
    }

    @Override
    public void execute(VenueList venueList) {

    }
}
