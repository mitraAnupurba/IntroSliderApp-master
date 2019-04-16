package com.example.introsliderapp.model;

public class CollegePlacementTraininhInstitute extends Institute {

    public CollegePlacementTraininhInstitute() {
    }

    public CollegePlacementTraininhInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType);
    }

    @Override
    public String toString() {
        return instituteName;
    }
}
