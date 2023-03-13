package seedu.duke;

public class Ui {

    public static void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showWelcome() {
        showLine();
        System.out.println("Hello! Welcome to EveNtUS!");
        showLine();
    }

    public static void showGuide() {
        showLine();
        showHelpText();
        showLine();
    }

    public static void showExitMessage() {
        showLine();
        System.out.println("Bye!");
        showLine();
        exitProgram();
    }

    public static void exitProgram() {
        System.exit(0);
    }

    private static void showHelpText() {
        System.out.println("Here are the functions of the application!");
        System.out.println("To add a company, type:");
        System.out.println("        add n/<COMPANY_NAME> c/<CONTACT_NUMBER> e/<EMAIL>");
        System.out.println(" ");
        System.out.println("To list companies, type:");
        System.out.println("                    list companies");
        System.out.println(" ");
        System.out.println("To list venues, type:");
        System.out.println("                    list venues");
        System.out.println(" ");
        System.out.println("To delete, type:");
        System.out.println("                    delete <INDEX>");
        System.out.println(" ");
        System.out.println("To display this guide at any time, type:");
        System.out.println("                    show guide");
        System.out.println(" ");
    }

}
