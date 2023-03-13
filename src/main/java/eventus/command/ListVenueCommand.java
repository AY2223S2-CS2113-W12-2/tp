package eventus.command;

import eventus.venue.VenueList;

public class ListVenueCommand extends Command{
    public ListVenueCommand(String commandType){
        super(commandType);
    }

    @Override
    public void execute(VenueList venueList) {

    }
}
