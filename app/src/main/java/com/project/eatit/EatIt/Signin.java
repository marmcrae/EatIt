package com.project.eatit.EatIt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.eatit.Common.Common;
import com.project.eatit.Model.User;
import com.project.eatit.R;

import io.paperdb.Paper;

public class Signin extends AppCompatActivity {

    public EditText passwordET;
    public EditText phoneNumET;
    public Button signInBtn;
   // CheckBox chkRemember;
   // ImageButton showHideBtn;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        passwordET = (EditText) findViewById(R.id.editTextPW);
        phoneNumET = (EditText) findViewById(R.id.editTextPhone);
        signInBtn = (Button) findViewById(R.id.signinBtn);
       // chkRemember = findViewById(R.id.chkRemeber);
//        showHideBtn = findViewById(R.id.showHideBtn);
//
//        showHideBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (flag == true) {
//                    flag = false;
//                    passwordET.setTransformationMethod(null);
//                    if (passwordET.getText().length() > 0)
//                        passwordET.setSelection(passwordET.getText().length());
//
//                } else {
//                    flag = true;
//                    passwordET.setTransformationMethod(new PasswordTransformationMethod());
//                    if (passwordET.getText().length() > 0)
//                        passwordET.setSelection(passwordET.getText().length());
//                }
//            }
//        });

        Paper.init(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Common.isConnectedToInternet(getBaseContext())) {

//                    if (chkRemember.isChecked()) {
//                        Paper.book().write(Common.USER_KEY, phoneNumET.getText().toString());
//                        Paper.book().write(Common.PWD_KEY, passwordET.getText().toString());
//                    }

                }

                final ProgressDialog mDialog = new ProgressDialog(Signin.this);
                mDialog.setMessage("Processing....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if (dataSnapshot.child(phoneNumET.getText().toString()).exists()) {


                            mDialog.dismiss();
                            User user = dataSnapshot.child(phoneNumET.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(passwordET.getText().toString())) {

                                Intent homeIntent = new Intent(Signin.this, Home.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();


                                Toast.makeText(Signin.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Signin.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(Signin.this, "User not found", Toast.LENGTH_LONG).show();
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
