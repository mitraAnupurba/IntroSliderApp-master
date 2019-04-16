package com.example.introsliderapp.model;

public class ManagementExamInstitute extends Institute {

    public ManagementExamInstitute() {
    }

    public ManagementExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
