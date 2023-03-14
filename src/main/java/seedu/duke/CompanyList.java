package seedu.duke;

import eventus.company.Company;

import java.util.ArrayList;

public class CompanyList {

    private static ArrayList<Company> companyList;

    public CompanyList(ArrayList<Company> companyList) {
        this.companyList = companyList;
    }

    public static void listCompanyInformation() throws EmptyListException{
        if (companyList.size() == 0) {
            throw new EmptyListException();
        }
        else {
            for (int i = 0; i < companyList.size(); i += 1) {
                System.out.println((i+1) + ". " + companyList.get(1));
            }
        }
    }
}
