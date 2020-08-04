package com.project.eatit.EatIt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.eatit.Common.Common;
import com.project.eatit.Model.User;
import com.project.eatit.R;

public class SignUp extends AppCompatActivity {

    public EditText signUpNameET;
    public EditText signUpPhoneET;
    public EditText signUpPWET;
    public Button signUpButton;
    public String phoneNumber;
    private ImageButton showHideBtn;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = (Button) findViewById(R.id.signUpBtn);
        signUpNameET = (EditText) findViewById(R.id.signUpNameET);
        signUpPhoneET = (EditText) findViewById(R.id.signUpPhoneET);
        signUpPWET = (EditText) findViewById(R.id.signUpPWET);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user= database.getReference("User");

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = signUpPhoneET.getText().toString();
                if ( number.isEmpty() || number.length()> 13) {
                    signUpPhoneET.setError("Please enter valid 10 digit phone number");
                    signUpPhoneET.requestFocus();
                    return;
                }

                if (Common.isConnectedToInternet(getBaseContext())) {

                    phoneNumber = number;

                    Intent intent = new Intent (SignUp.this, Home.class);
                    intent.putExtra("phoneNumber", phoneNumber);
                    startActivity(intent);
                }


                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Processing...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(signUpPhoneET.getText().toString()).exists()) {

                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "Phone number registered", Toast.LENGTH_LONG).show();
                        } else {

                            mDialog.dismiss();
                            User user = new User(signUpNameET.getText().toString(), signUpPWET.getText().toString());
                            table_user.child(signUpPhoneET.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "User created!", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
