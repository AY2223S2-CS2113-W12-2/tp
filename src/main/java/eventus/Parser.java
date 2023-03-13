package eventus;

import eventus.command.Command;
import eventus.command.DeleteCommand;
import eventus.command.ListCompanyCommand;
import eventus.command.ListVenueCommand;

public interface Parser {
    static Command parse(String input){
        String[] inputWords = input.split(" ");
        String command = inputWords[0];
        switch (command) {
        case "list":
            if (inputWords[1].equals("companies")) {
                ListCompanyCommand companyCommand = new ListCompanyCommand(command);
                return companyCommand;
            } else if (inputWords[1].equals("venues")) {
                ListVenueCommand venueCommand = new ListVenueCommand(command);
                return venueCommand;
            }
            System.out.println("Unknown input!");
            break;
        case "add":
            System.out.println(input.replaceFirst(command, "").trim());
            break;
        case "delete":
            int taskNum = Integer.parseInt(inputWords[1]) - 1;
            DeleteCommand deleteCommand = new DeleteCommand(command, taskNum);
            return deleteCommand;
        case "help":
            Ui.showGuide();
            break;
        case "exit":
            Ui.showExitMessage();
            break;
        default:
            System.out.println("Unknown input!");
        }
        return null;
    }
}
