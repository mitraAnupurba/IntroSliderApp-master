package com.example.introsliderapp.model;

public class NeetPGInstitute extends Institute {
    public NeetPGInstitute() {
    }

    public NeetPGInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
