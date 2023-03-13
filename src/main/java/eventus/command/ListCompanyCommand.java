package eventus.command;

import eventus.venue.VenueList;

public class ListCompanyCommand extends Command{
    public ListCompanyCommand(String commandType){
        super(commandType);
    }

    @Override
    public void execute(VenueList venueList) {

    }
}
