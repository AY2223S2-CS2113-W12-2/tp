package seedu.duke;

import seedu.duke.command.*;

import java.util.Arrays;
import java.util.List;

public interface Parser {
    static Command parse(String input) throws WrongFormatException{

        Ui ui = new Ui();
        String[] inputWords = input.split(" ");
        String command = inputWords[0];
        switch (command) {
        case "list":
            if (inputWords.length == 1){
                throw new WrongFormatException();
            }
            if (inputWords[1].equals("companies")) {
                ListCompanyCommand companyCommand = new ListCompanyCommand(command + " companies");
                return companyCommand;
            } else if (inputWords[1].equals("venues")) {
                ListVenueCommand venueCommand = new ListVenueCommand(command + " venues");
                return venueCommand;
            }
            throw new WrongFormatException();
        case "add":
            input = input.replaceFirst("add n/", "").trim();
            int indexOfSlash = input.indexOf("/");
            int lastIndexOfSlash = input.lastIndexOf("/");
            String companyName = input.substring(0, indexOfSlash - 2);
            String contactNumber = input.substring(indexOfSlash + 1, lastIndexOfSlash - 2);
            String contactEmail = input.substring(lastIndexOfSlash + 1);
            AddCommand addCommand = new AddCommand(command, companyName, contactNumber, contactEmail);
            return addCommand;
        case "delete":
            int taskNum = Integer.parseInt(inputWords[1]) - 1;
            DeleteCommand deleteCommand = new DeleteCommand(command, taskNum);
            return deleteCommand;
        case "help":
            ui.showGuide();
            break;
        case "exit":
            ui.showExitMessage();
            break;
        default:
            throw new WrongFormatException();
        }
        Command c = new Command(command);
        return c;
    }
}
