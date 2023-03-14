package seedu.duke;

import eventus.company.Company;

import java.util.ArrayList;

public class CompanyList {

    ArrayList<Company> companies = new ArrayList<>();


    public void listCompanyInformation()  {
        if (companies.size() == 0) {
            System.out.println("no");
        }
        else {
            for (int i = 0; i < companies.size(); i += 1) {
                System.out.println((i+1) + ". " + companies.get(1));
            }
        }
    }

    public boolean add(String companyName, int contactNumber, String contactEmail){
        try{
            Company newCompany = new Company(companyName, contactNumber, contactEmail);
            companies.add(newCompany);
            return true;
        } catch(seedu.duke.InputMismatchException e){
            return false;
        }
    }


}
