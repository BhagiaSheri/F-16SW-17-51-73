package com.example.hp.facebookapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.squareup.picasso.Picasso;


public class LoginActivity extends AppCompatActivity {

    ShareDialog shareDialog;
    FloatingActionButton fab;
    Toolbar tb;
    TextView nameTV;
    ImageView profileIM;
    Button logoutBtn;
    String fname,lname,imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        shareDialog=new ShareDialog(this);


         nameTV=findViewById(R.id.nameTextView);
         profileIM=findViewById(R.id.profileImageView);
         logoutBtn=findViewById(R.id.logoutBtn);
         fab=findViewById(R.id.fab);

         logoutBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 LoginManager.getInstance().logOut();
                 Intent login=new Intent(LoginActivity.this,MainActivity.class);
                 startActivity(login);
                 finish();
             }
         });

         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ShareLinkContent content=new ShareLinkContent.Builder().build();
                 shareDialog.show(content);
             }
         });


        Intent details = getIntent();
        fname=details.getStringExtra("fname");
        lname=details.getStringExtra("lname");
        imgUrl=details.getStringExtra("profilePic");

        nameTV.setText(fname+" "+lname);
        Picasso.with(this)
                .load(imgUrl)
                .fit()
                .centerCrop()
                .into(profileIM);
    }
}
