package com.example.introsliderapp.model;

public class MedicalEntranceInstitute extends Institute {

    public MedicalEntranceInstitute() {
    }

    public MedicalEntranceInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
