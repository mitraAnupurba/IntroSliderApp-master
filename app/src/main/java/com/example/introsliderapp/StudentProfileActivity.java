package com.example.introsliderapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.introsliderapp.model.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//Class for the opearation's in students profile activity, like view data, update data,
//rate institute, delete data, etc.
public class StudentProfileActivity extends AppCompatActivity {

    //variable to display Logs for testing purpose:
        private static final String TAG ="my tag" ;

    //Firebase Auth variable.
        private FirebaseAuth mAuth;

    //View's variables:
        private Toolbar toolbar;
        private String uid;
        private RatingBar ratingBar;
    //edittext's for update dialog:
        private EditText phoneNumberStudentUpdate
                ,userNameStudentUpdate,
                instNameStudentUpdate,examNameStudentUpdate,reviewStudentEdittext;
    //test view for user data display
        private TextView emailAddressStudent,phoneNumberStudent,userNameStudent,
                            dobStudent,instNameStudent,examNameStudent;

    //strings for initial data store and display:
        private String email,phNumber,userName,dob,instName,examName;

    //strings for updated value:
        private String phNumberUpdatedValue,userNameUpdatedValue
                ,instNameUpdatedValue,examNameUpdatedValue;

    //variable to get the rating and review:
        private String studentReview;
        private float studentRating;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        initViews();
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        //fetch data:
        fetchData();



    }

    //Function to initialise the view components:
    private void initViews(){

        emailAddressStudent = this.findViewById(R.id.email_address_textView);
        phoneNumberStudent = this.findViewById(R.id.phone_number_textView);
        userNameStudent = this.findViewById(R.id.user_name_textView);
        dobStudent = this.findViewById(R.id.dob_student_signup_textView);
        instNameStudent = this.findViewById(R.id.institute_name_textView);
        examNameStudent = this.findViewById(R.id.exam_name_textView);
        toolbar = this.findViewById(R.id.toolbar_student_profile);
    }
    //Function to initialise the view components ends here.


    //Function to set the view components, called from the fetchData() function:
    private void setViews(){
        emailAddressStudent.setText("Email Address : "+email);
        phoneNumberStudent.setText("Phone NUmber : "+phNumber);
        userNameStudent.setText("User Name : "+userName);
        dobStudent.setText("Date Of Birth"+dob);
        instNameStudent.setText("Institute Name : "+instName);
        examNameStudent.setText("Exam Preparing For : "+examName);
        toolbar.setTitle(userName);
        toolbar.setSubtitle("welcome");
    }
    //Function to set the view components ends here.


    //function to map the menu_main layout to out layout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    //function to map the menu_main layout to out layout ends here.


    //function to make a functional toolbar, adding functionality to each of the menu items:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.update:
                showUpdateDialog();
                break;
            case R.id.delete:
                showDeleteDialog();
                break;
            case R.id.logout:
                showLogout();
                break;
            case R.id.rate:
                showRatingBar();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    //Function to make a functional toolbar ends here.


    //function to show the update dialog and update data:
    private void showUpdateDialog() {

        //variable to get Alert dialog:
        AlertDialog.Builder updateDialog = new AlertDialog.Builder(StudentProfileActivity.this);
        View v = getLayoutInflater().inflate(R.layout.update_dialog,null);

        //getting the views:
        phoneNumberStudentUpdate = v.findViewById(R.id.phone_number_edittext_update);
        userNameStudentUpdate = v.findViewById(R.id.user_name_edittext_update);
        instNameStudentUpdate = v.findViewById(R.id.institute_name_edittext_update);
        examNameStudentUpdate = v.findViewById(R.id.exam_name_edittext_update);

        //seting default values to the view items:
        phoneNumberStudentUpdate.setText(phNumber);
        userNameStudentUpdate.setText(userName);
        instNameStudentUpdate.setText(instName);
        examNameStudentUpdate.setText(examName);


        //code for creating the alert dialog and adding finctionality to it:
        updateDialog.setView(v);
        updateDialog.setTitle("UPDATE VALUES: Email and D.O.B are NON Editable");
        updateDialog.create();
        updateDialog.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //getting the updated values.
                phNumberUpdatedValue = phoneNumberStudentUpdate.getText().toString().trim();
                userNameUpdatedValue = userNameStudentUpdate.getText().toString().trim();
                instNameUpdatedValue = instNameStudentUpdate.getText().toString().trim();
                examNameUpdatedValue = examNameStudentUpdate.getText().toString().trim();

                //validation for the updated data entries
                if(phNumberUpdatedValue.isEmpty()){
                    phoneNumberStudentUpdate.setError("field is empty");
                    phoneNumberStudentUpdate.requestFocus();

                }
                else if(userNameUpdatedValue.isEmpty()){
                    userNameStudentUpdate.setError("field is empty");
                    userNameStudentUpdate.requestFocus();

                }
                else if(instNameUpdatedValue.isEmpty()){
                    instNameStudentUpdate.setError("field is empty");
                    instNameStudentUpdate.requestFocus();

                }
                else if(examNameUpdatedValue.isEmpty()){
                    examNameStudentUpdate.setError("field is empty");
                    examNameStudentUpdate.requestFocus();

                }//validation ends here
                else{
                        //function call for the update data functionality:
                        updateData(phNumberUpdatedValue,userNameUpdatedValue
                        ,instNameUpdatedValue,examNameUpdatedValue);

                        //setting the updated values in the main users profile page:
                        phoneNumberStudent.setText(phNumberUpdatedValue);
                        userNameStudent.setText(userNameUpdatedValue);
                        instNameStudent.setText(instNameUpdatedValue);
                        examNameStudent.setText(examNameUpdatedValue);
                }


            }
        });
        updateDialog.setNegativeButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        updateDialog.setCancelable(false);
        updateDialog.show();

        //Toast.makeText(this,"update clicked",Toast.LENGTH_SHORT).show();
    }
    //function to create and show the update dialog ends here.

    //function to update the data of users and storing it in firebase database:
    private void updateData(String phNumberUpdatedValue, String userNameUpdatedValue, String instNameUpdatedValue, String examNameUpdatedValue) {

        DatabaseReference mRef = FirebaseDatabase.getInstance()
                .getReference("users").child("student").child(uid);
        Student updatedStudent = new Student(userNameUpdatedValue,email,phNumberUpdatedValue
                            ,instNameUpdatedValue,examNameUpdatedValue,dob);
        mRef.setValue(updatedStudent).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(StudentProfileActivity.this,"data updated successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    //function to update data and store it in firebse database ends here.


    //function to show the delete dialog and delete data:
    private void showDeleteDialog() {

        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(StudentProfileActivity.this);
        deleteDialog.setMessage("Are you sure you want to delete this account?");
        deleteDialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DatabaseReference mRef = FirebaseDatabase.getInstance()
                        .getReference("users").child("student").child(uid);

                //firebase current user to be deleted:
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                mRef.removeValue();
                mAuth.signOut();
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(StudentProfileActivity.this,"User Deleted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),StudentLoginActivity.class));
                            StudentProfileActivity.this.finish();
                        }
                    }
                });
                Toast.makeText(StudentProfileActivity.this,"Account Deleted",Toast.LENGTH_SHORT).show();

            }
        });
        deleteDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        deleteDialog.setCancelable(false);
        deleteDialog.show();

    }
    //function to show the delete dialog and delete te account ends here.

    //function to sign out from the account:
    private void showLogout() {
        mAuth.signOut();
        startActivity(new Intent(getApplicationContext(),StudentLoginActivity.class));
        StudentProfileActivity.this.finish();
    }
    //function to signout ends here.

    //function to show the rating dialog and rate institute:
    private void showRatingBar(){

        android.app.AlertDialog.Builder ratingDialog = new android.app.AlertDialog.Builder(StudentProfileActivity.this);
        View view = getLayoutInflater().inflate(R.layout.rating_layout,null);

        //getting the views:
        ratingBar = view.findViewById(R.id.rating_bar);
        reviewStudentEdittext = view.findViewById(R.id.review_edittext);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                studentRating = rating;
                Log.d(TAG,"\n details are as follows \n");
                Log.d(TAG,Float.toString(rating)+"\n");
                Log.d(TAG,Float.toString(studentRating)+"\n");


            }
        });

        ratingDialog.setView(view);
        ratingDialog.setTitle("RATE US");
        ratingDialog.create();
        ratingDialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG,"\n inside set positve button Listener \n");
                studentReview = reviewStudentEdittext.getText().toString().trim();
                Log.d(TAG,studentReview+"\n");
            }
        });
        ratingDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ratingDialog.setCancelable(false);
        ratingDialog.show();
    }
    //function to show the rating dialog and rate institute ends here.



    //function to fetch data from firebase realtime database:
    private void fetchData(){

        FirebaseDatabase.getInstance().getReference("users").
                child("student").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);

                //get values:
                email = student.getEmailAddressStudent();
                phNumber = student.getPhoneNumberStudent();
                userName = student.getUserNameStudent();
                dob = student.getDobStudent();
                instName = student.getInstituteNameStudent();
                examName = student.getExamName();

                setViews();

                //logs display for testing:
                Log.d(TAG,"onDataChanged : Student Information");
                Log.d(TAG,"Email Address : "+email);
                Log.d(TAG,"User Name : "+userName);
                Log.d(TAG,"DOB : "+dob);
                Log.d(TAG,"Phone Number : " + phNumber);
                Log.d(TAG,"Institute Name : "+instName);
                Log.d(TAG,"Exam Preparing For : " + examName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StudentProfileActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });


    }
    //function to fetch data from firebase realtime database ends here.
}
