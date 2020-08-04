package com.project.eatit.EatIt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.project.eatit.R;

import java.util.concurrent.TimeUnit;

public class AuthSignUp extends AppCompatActivity {

//    private String verificationId;
//    private FirebaseAuth mAuth;
//    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_sign_up);

//
//        mAuth = FirebaseAuth.getInstance();
//        editText = findViewById(R.id.edtOtp);
//
//        String phoneNumber = getIntent().getStringExtra("phoneNumber");
//
//        sendVerificationCode(phoneNumber);
//
////        findViewById(R.id.signinBtn).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                String code = editText.getText().toString().trim();
////                if (code.isEmpty() || code.length() < 6) {
////                    editText.setError("Enter code...");
////                    editText.requestFocus();
////                    return;
////                }
////                verifyCode(code);
////            }
////
////        });
////
////    }
//
//    private void verifyCode(String code) {
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//        SignInWithCredential(credential);
//
//    }
//
//    private void SignInWithCredential(PhoneAuthCredential credential) {
//
//        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    Intent intent = new Intent(AuthSignUp.this, Home.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                } else {
//
//                    Toast.makeText(AuthSignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//
//                }
//
//            }
//        });
//
//    }
//
//    private void sendVerificationCode(String number) {
//
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                number,
//                60,
//                TimeUnit.SECONDS,
//                TaskExecutors.MAIN_THREAD,
//                mCallback
//        );
//
//    }
//
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
//
//            verificationId = s;
//
//
//        }
//
//        @Override
//        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//            String code = phoneAuthCredential.getSmsCode();
//            if (code != null)
//                editText.setText(code);
//            verifyCode(code);
//        }
//
//        @Override
//        public void onVerificationFailed(@NonNull FirebaseException e) {
//            Toast.makeText(AuthSignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }
    }
}
