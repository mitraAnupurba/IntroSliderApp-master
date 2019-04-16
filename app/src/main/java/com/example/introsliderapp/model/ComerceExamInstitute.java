package com.example.introsliderapp.model;

public class ComerceExamInstitute extends Institute {

    public ComerceExamInstitute() {
    }

    public ComerceExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
