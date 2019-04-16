package com.example.introsliderapp.model;

public class BankExamInstitute extends Institute {

    public BankExamInstitute() {
    }

    public BankExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
