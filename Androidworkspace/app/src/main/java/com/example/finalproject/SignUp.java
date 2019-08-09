package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    AndroidController andcon = AndroidController.getInstance();
    public Button btnSignSend,SignUpNext;
    public EditText edtId, edtPass, edtPass2, edtName, edtBirth, edtEmail,edtNickName;
    int number;
    public int count;
    RadioGroup RadioGp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtNickName = findViewById(R.id.edtNickName);
        edtId = findViewById(R.id.edtId);
        edtPass = findViewById(R.id.edtPass);
        edtName = findViewById(R.id.edtName);
        edtBirth = findViewById(R.id.edtBirth);
        edtEmail = findViewById(R.id.edtEmail);
        SignUpNext = findViewById(R.id.SignUpNext);
        RadioGp = findViewById(R.id.RadioGp);
        RadioGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.check:
                        if(number == 0){
                            number++;
                            count++;
                            if(count==2){
                                SignUpNext.setEnabled(true);
                            }
                        }
                        break;
                    case R.id.noncheck:
                        if(number == 1){
                            number--;
                            count--;
                            if(count==1){
                                SignUpNext.setEnabled(false);
                            }
                        }
                        break;
                }
            }
        });
    }
    public void idoverlap (View v){
        String id = edtId.getText().toString();
        if(!id.equals("")) {
            andcon.sub(SignUp.this, "Memberidoverlap");
            if(count==2){
                SignUpNext.setEnabled(true);
            }
        }else{
            Toast.makeText(this, "아이디를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }

    }
    public void SignUpNext(View view) {
        String id = edtId.getText().toString();
        String pass =edtPass.getText().toString();
        String pass2 = edtPass2.getText().toString();
        String Name =edtName.getText().toString();
        String Birth =edtBirth.getText().toString();
        String Email =edtEmail.getText().toString();
        String Nick =edtNickName.getText().toString();
        if(pass.equals("")&&pass2.equals("")&&Name.equals("")&&Birth.equals("")&&Email.equals("")&&Nick.equals("")){
            Toast.makeText(this, "정보를 모두 입력해 주세요", Toast.LENGTH_SHORT).show();
        }else{
            if(pass.equals(pass2)){
                MemberBean memberBean = new MemberBean();
                memberBean.setM_id(id);
                memberBean.setM_pass(pass);
                memberBean.setM_name(Name);
                memberBean.setM_birthday(Birth);
                memberBean.setM_email(Email);
                memberBean.setM_nickname(Nick);
                andcon.member = memberBean;
                andcon.sub(this,"InsertMember");
            }else{
                Toast.makeText(this, "비밀번호와 비밀번호 확인이 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
