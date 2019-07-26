package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    Button btnSignSend;
    EditText edtId, edtPass, edtPass2, edtName, edtBirth, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtId = findViewById(R.id.edtId);
        edtPass = findViewById(R.id.edtPass);
        edtName = findViewById(R.id.edtName);
        edtBirth = findViewById(R.id.edtBirth);
        edtEmail = findViewById(R.id.edtEmail);



    }

    public void SignUpNext(View view) {

        String MemberId = edtId.getText().toString();
        String MemberPass = edtPass.getText().toString();
        String MemberPass2 = edtPass2.getText().toString();
        String MemberName = edtName.getText().toString();
        String MemberBirth = edtBirth.getText().toString();
        String MemberEmail = edtEmail.getText().toString();


    }

}
