package com.example.hp.lab3task;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInfo extends AppCompatActivity {
    String un,em,pass,dob,gender;
    TextView t1,t2,t3,tv;
    //Button b;
    ImageView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Intent in3 = getIntent();
        un=in3.getStringExtra("un");
        em=in3.getStringExtra("em");
        pass=in3.getStringExtra("pass");
        dob=in3.getStringExtra("dofb");
        gender=in3.getStringExtra("gen");
        t1=findViewById(R.id.un_tv);
        t2=findViewById(R.id.email_tv);
        t3=findViewById(R.id.gender_tv);
         b=findViewById(R.id.button3);
         //img=findViewById(R.id.image);
        t1.setText(un);
        t2.setText(em);
        t3.setText(gender);
    }
    public void infoClick(View v){
    // img.setImageResource(R.drawable.welcome);

        b.setImageResource(R.drawable.welcome1);
     }
}
