package com.example.introsliderapp.model;

public class EngineeringExamInstitute extends Institute {

    public EngineeringExamInstitute() {
    }

    public EngineeringExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
