package com.example.introsliderapp.model;

public class UpscInstitute extends Institute {

    public UpscInstitute() {
    }

    public UpscInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
