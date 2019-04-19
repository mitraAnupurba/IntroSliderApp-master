package com.example.introsliderapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.introsliderapp.model.BankExamInstitute;
import com.example.introsliderapp.model.CollegePlacementTraininhInstitute;
import com.example.introsliderapp.model.ComerceExamInstitute;
import com.example.introsliderapp.model.EngineeringExamInstitute;
import com.example.introsliderapp.model.GREInstitute;
import com.example.introsliderapp.model.IITJEEInstitute;
import com.example.introsliderapp.model.ManagementExamInstitute;
import com.example.introsliderapp.model.MedicalEntranceInstitute;
import com.example.introsliderapp.model.NeetPGInstitute;
import com.example.introsliderapp.model.ScienceExamInstitute;
import com.example.introsliderapp.model.UpscInstitute;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.introsliderapp.MainActivity.bankExam;
import static com.example.introsliderapp.MainActivity.collegePlacementTraininh;
import static com.example.introsliderapp.MainActivity.comerceExam;
import static com.example.introsliderapp.MainActivity.engineeringExam;
import static com.example.introsliderapp.MainActivity.gre;
import static com.example.introsliderapp.MainActivity.iitjee;
import static com.example.introsliderapp.MainActivity.managementExam;
import static com.example.introsliderapp.MainActivity.medicalEntrance;
import static com.example.introsliderapp.MainActivity.neetPG;
import static com.example.introsliderapp.MainActivity.scienceExam;
import static com.example.introsliderapp.MainActivity.upsc;

public class IITJEEInstitutesView extends AppCompatActivity {

    private static final String TAG = "mt tag";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iitjeeinstitutes_view);

        /*Log.d(TAG,iitjee.toString());
        Log.d(TAG,medicalEntrance.toString());
        Log.d(TAG,engineeringExam.toString());
        Log.d(TAG,neetPG.toString());
        Log.d(TAG,scienceExam.toString());
        Log.d(TAG,comerceExam.toString());
        Log.d(TAG,upsc.toString());
        Log.d(TAG,bankExam.toString());
        Log.d(TAG,collegePlacementTraininh.toString());
        Log.d(TAG,managementExam.toString());
        Log.d(TAG,gre.toString());*/


    }


    //function to initialise the array lists of institutes:
    //private void initList(){


    //}
    //function to initialise the array lists of institutes:

}
