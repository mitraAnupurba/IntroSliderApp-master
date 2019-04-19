package com.example.introsliderapp.model;

import java.util.ArrayList;
import java.util.Comparator;

public class IITJEEInstitute extends Institute implements Comparator<IITJEEInstitute> {


    public IITJEEInstitute() {
    }

    public IITJEEInstitute(String instituteName, String instituteAddress, String emailAddress, String phoneNumber, String instituteType,float avg) {
        super(instituteName, instituteAddress, emailAddress, phoneNumber, instituteType,avg);
    }




    @Override
    public String toString() {
        return instituteName;
    }

    @Override
    public int compare(IITJEEInstitute o1, IITJEEInstitute o2) {
        if(o1.getAvg() > o2.getAvg())
            return -1;
        else
            return 1;
    }
}
