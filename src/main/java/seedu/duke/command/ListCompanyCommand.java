package seedu.duke.command;


import seedu.duke.CompanyList;


public class ListCompanyCommand extends Command{
    public ListCompanyCommand(String commandType){
        super(commandType);
    }


    public void execute(CompanyList companyList){
        companyList.listCompanyInformation();
    }
}
