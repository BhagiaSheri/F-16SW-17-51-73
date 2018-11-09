package com.example.hp.lab3task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et1,et2;
    String un,em,pass,dob,gender,u_name,u_pass;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=findViewById(R.id.username);
        et2=findViewById(R.id.password);
        bt=findViewById(R.id.button);
        Intent in2 = getIntent();
        un=in2.getStringExtra("uname");
        em=in2.getStringExtra("email");
        pass=in2.getStringExtra("password");
        dob=in2.getStringExtra("dob");
        gender=in2.getStringExtra("gender");

    }
    public void loginClick(View v){
        u_name=et1.getText().toString();
       u_pass=et2.getText().toString();
    if(u_name.equals(un)&&u_pass.equals(pass)){
          Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(LoginActivity.this,UserInfo.class);
           intent.putExtra("un",un);
           intent.putExtra("em",em);
          intent.putExtra("pass",pass);
          intent.putExtra("dofb",dob);
          intent.putExtra("gen",gender);
           startActivity(intent);
       }
       else{
           Toast.makeText(getApplicationContext(),"Invalid Password or Username!",Toast.LENGTH_SHORT).show();
       }
    }
}
