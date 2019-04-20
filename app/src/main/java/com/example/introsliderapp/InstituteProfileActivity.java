package com.example.introsliderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class InstituteProfileActivity extends AppCompatActivity {

    private Button logoutButtonInstitute;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_profile);

        mAuth = FirebaseAuth.getInstance();
        logoutButtonInstitute = this.findViewById(R.id.logout_button_institute);
        logoutButtonInstitute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),InstituteLoginActivity.class));
                InstituteProfileActivity.this.finish();
            }
        });

    }
}
