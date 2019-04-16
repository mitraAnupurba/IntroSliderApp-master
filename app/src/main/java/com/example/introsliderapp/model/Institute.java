package com.example.introsliderapp.model;

import java.util.ArrayList;
import java.util.Comparator;

//model class for the institute object passed to the firebase database:

public class Institute implements Comparator<Institute> {

    String instituteName, instituteAddress, emailAddress,phoneNumber,instituteType;
    ArrayList<Float> ratingArray=  new ArrayList<>();
    float avg ;

    public Institute(){

    }
    public Institute(String instituteName,String instituteAddress,
                     String emailAddress,String phoneNumber,String instituteType){

        this.instituteName = instituteName;
        this.instituteAddress =instituteAddress;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.instituteType = instituteType;

    }

    public void setRatingArray(float i){

        ratingArray.add(i);
        calculateAverage(i);

    }
    public void calculateAverage(float i){

        float sum = 0.0f;
        for(int k=0;k<ratingArray.size();k++){
            sum = sum+ratingArray.get(k);
        }
        avg = sum/ratingArray.size();
    }
    public float getAvg(){
        return avg;
    }

    @Override
    public int compare(Institute o1, Institute o2) {
        if(o1.getAvg() > o2.getAvg())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "instituteName='" + instituteName + '\'' +
                '}';
    }

    public String getInstituteName() {
        return instituteName;
    }

    public String getInstituteAddress() {
        return instituteAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
