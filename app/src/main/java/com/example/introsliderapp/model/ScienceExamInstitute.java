package com.example.introsliderapp.model;

public class ScienceExamInstitute extends Institute {

    public ScienceExamInstitute() {
    }

    public ScienceExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
