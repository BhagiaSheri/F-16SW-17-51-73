package com.example.hp.lab3task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_signup extends AppCompatActivity {
//    TextView t1,t2,t3,t4,t5;
    EditText e1,e2,e3,e4;
    RadioGroup rg;
    RadioButton rb;
    Button btn;
    String un,email,pass,dob,gender;
    int rb_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);
        e1=findViewById(R.id.uname_et);
        e2=findViewById(R.id.email_et);
        e3=findViewById(R.id.pass_et);
        e4=findViewById(R.id.dob_et);
        rg=findViewById(R.id.radioGroup2);
        btn=findViewById(R.id.signUp_btn);
        }

        public void signUpClick(View v){
        un=e1.getText().toString();
        email=e2.getText().toString();
        pass=e3.getText().toString();
        dob=e4.getText().toString();
        rb_id=rg.getCheckedRadioButtonId();
        rb=findViewById(rb_id);
        gender=rb.getText().toString();
            Toast.makeText(getApplicationContext(),"Sigh Up Successfull",Toast.LENGTH_SHORT).show();
            Intent in1 = new Intent(MainActivity_signup.this,LoginActivity.class);
            in1.putExtra("uname",un);
            in1.putExtra("email",email);
            in1.putExtra("password",pass);
            in1.putExtra("dob",dob);
            in1.putExtra("gender",gender);
            startActivity(in1);
        }
}
