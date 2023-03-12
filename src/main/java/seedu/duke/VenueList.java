package seedu.duke;

import java.util.ArrayList;

public class VenueList {

    private static ArrayList<Venue> venueList;

    public VenueList(ArrayList<Venue> venueList) {
        this.venueList = venueList;
    }
    public static void print() throws EmptyListException {
        if (venueList.isEmpty()) {
            throw new EmptyListException();
        }
        for (int i = 0; i < venueList.size(); i++) {
            System.out.println(venueList.get(i));
        }
    }
}
