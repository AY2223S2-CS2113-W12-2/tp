package seedu.duke;

import eventus.company.Company;

import java.util.ArrayList;

public class CompanyList {

    ArrayList<Company> companies = new ArrayList<>();

    public void listCompanyInformation() throws EmptyListException{
        if (companies.size() == 0) {
            throw new EmptyListException();
        }
        else {
            for (int i = 0; i < companies.size(); i += 1) {
                System.out.println((i+1) + ". " + companies.get(1));
            }
        }
    }
}
