package com.example.introsliderapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.introsliderapp.model.Admin;
import com.example.introsliderapp.model.BankExamInstitute;
import com.example.introsliderapp.model.CollegePlacementTraininhInstitute;
import com.example.introsliderapp.model.ComerceExamInstitute;
import com.example.introsliderapp.model.EngineeringExamInstitute;
import com.example.introsliderapp.model.GREInstitute;
import com.example.introsliderapp.model.IITJEEInstitute;
import com.example.introsliderapp.model.Institute;
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
//class for the main app dashboard display:


//error: - the app was crashing on clicking the back button
//how to fix : after starting the actiivity, the app should not finish. that is, we cant call this.finish()


//in order to add action bar only to specific items, apply theme to indivisual activities in the manifests.xml file

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="my tag" ;
    String adminEmail, adminPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating object for the singelton class admin:
        adminEmail = getString(R.string.admin_email);
        adminPassword = getString(R.string.admin_password);
        Admin.createObject(adminEmail,adminPassword);
        Log.d(TAG,adminEmail+adminPassword);

        //DatabaseReference mRef = FirebaseDatabase.getInstance().
                //getReference("users").child("institute").child("IIT-JEE");



    }

    //method implementation for the load slides button:
    public void loadSlides(View view) {
        new PreferenceManager(this).clearPreference();
        startActivity(new Intent(this,WelcomeActivity.class));

    }
    //method implementation for the load slides button ends here.


    //method for the locateInstitutes button:
    public void loadInstitutes(View view) {
        startActivity(new Intent(this,FindInstituteActivity.class));

    }
    //method for the locateInstitutes button ends here.


    //method for the institute sign up button:
    public void loadInstituteLogin(View view) {

        startActivity(new Intent(this,InstituteLoginActivity.class));

    }
    //method for the institute signup button ends here

    //method for the student sign up button:
    public void loadStudentLogin(View view) {

        startActivity(new Intent(this,StudentLoginActivity.class));

    }
    //method for the student signup button ends here

    //method for the parent sign up button:
    public void loadParentLogin(View view) {

        startActivity(new Intent(this,ParentLoginActivity.class));

    }
    //method for the parent signup button ends here

    //method for the admin sign up button:
    public void loadAdminLogin(View view) {

        startActivity(new Intent(this,AdminLoginActivity.class));

    }
    //method for the admin signup button ends here

    //method for the exam portal button:
    public void loadExamPortal(View view) {

        startActivity(new Intent(this,ExamPortalActivity.class));

    }
    //method for the exam portal button ends here.

    //method for the load app settings button:
    public void loadAppSettings(View view) {

        startActivity(new Intent(this,AppSettings.class));

    }
    //method for the load app settings button ends here.

    //method that displays the alert dialogue before exitting the app:
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //the set Cancellable method doesnt allow us to cancel the dialog box without choosing yes or no
        builder.setMessage("Are you sure you want to exit the app?").setCancelable(false)
        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                MainActivity.super.onBackPressed();
            }
        })
        .setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }) ;
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //if we use this, then the app crashes on clicking the exit button:
        //super.onBackPressed();
    }
    //method that displays the alert dialogue before exitting the app ends here.
}
