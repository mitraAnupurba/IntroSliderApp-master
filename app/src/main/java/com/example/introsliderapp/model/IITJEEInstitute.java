package com.example.introsliderapp.model;

public class IITJEEInstitute extends Institute {

    public IITJEEInstitute() {
    }

    public IITJEEInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
