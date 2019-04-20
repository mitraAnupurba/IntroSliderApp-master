package com.example.introsliderapp.model;

import java.util.ArrayList;

public class ComerceExamInstitute extends Institute {



    public ComerceExamInstitute() {
    }

    public ComerceExamInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType,float avg) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType,avg);
    }


    @Override
    public String toString() {
        return instituteName;
    }
}
