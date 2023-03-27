package seedu.duke.storage;

import seedu.duke.event.Event;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.ui.Ui;
import seedu.duke.venue.VenueList;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Format of event details in txt file:
 * Event Name|Venue Index
 * where venue index is the index of the venue inside the pre-determined venue list
 */

/**
 * Storage that handles the data from the event details text file
 */
public class EventDetailsStorage extends Storage{

    private static final String filePath = "data/eventDetails.txt";

    public static void eventDetailsInit(Event event, VenueList venueList) {
        try {
            checkFileAccess(filePath);
            load(event, venueList);
        } catch (FileNotFoundException err) {
            System.out.println("File not Found");
        } catch (IOException err) {
            System.out.println("Something went wrong");
        } catch (InvalidIndexException | NumberFormatException e) {
            System.out.println("Choose a new venue using choose venue <index>");
        } catch (NoSuchElementException e) {
            event.updateEventName("Default Event");
            updateFile(event);
        }
    }

    /**
     * Loads event details with data from event details save file if it exists
     *
     * @throws FileNotFoundException if error occurs due to no access to the text file
     * @throws NoSuchElementException if error occurs due to no next line found
     * @throws InvalidIndexException if error occurred due to invalid index
     * @throws NumberFormatException if error occurred due to the not reading a number when expected
     */
    public static void load(Event event, VenueList venueList) throws FileNotFoundException,
            NoSuchElementException, InvalidIndexException, NumberFormatException {
        File file = new File(filePath);
        Scanner s = new Scanner(file);
        String line = s.nextLine();
        String[] parsedLine = line.split("\\|");
        System.out.println("Retrieving your event data.....");
        event.updateEventName(parsedLine[0]);
        if (parsedLine.length == 1){
            throw new InvalidIndexException();
        }
        event.updateVenue(venueList,Integer.parseInt(parsedLine[1]));
        s.close();
    }

    /**
     * Updates event details text file with both event name and venue index
     *
     * @throws IOException if error occurred during file writing
     */
    public static void updateFile(Event event, int indexOfVenue) {
        try {
            String eventName = event.getEventName();
            writeToFile("", filePath);
            appendToFile(eventName + "|" + indexOfVenue, filePath);
        } catch (IOException err) {
            System.out.println("Something went wrong: " + err.getMessage());
        }
    }

    /**
     * Updates event details text file with event name only
     *
     * @throws IOException if error occurred during file writing
     */
    public static void updateFile(Event event){
        try {
            String eventName = event.getEventName();
            writeToFile("", filePath);
            appendToFile(eventName + "|", filePath);
        } catch (IOException err) {
            System.out.println("Something went wrong: " + err.getMessage());
        }
    }

}
