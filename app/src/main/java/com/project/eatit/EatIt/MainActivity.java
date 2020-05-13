package com.project.eatit.EatIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.eatit.R;

public class MainActivity extends AppCompatActivity {

    public Button signInBtn, signUpBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = (Button) findViewById(R.id.signinButton);
        signUpBtn = (Button) findViewById(R.id.signupButton);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInAct = new Intent(MainActivity.this, Signin.class);
                startActivity(signInAct);

            }
        });



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUpAct = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUpAct);

            }
        });
    }
}
