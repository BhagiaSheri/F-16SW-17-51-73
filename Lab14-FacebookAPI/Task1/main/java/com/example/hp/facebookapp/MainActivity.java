package com.example.hp.facebookapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    private LoginButton loginButton;

    TextView loginStatusTv;
    String fname,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);
        loginButton=findViewById(R.id.login_button);
        loginStatusTv=findViewById(R.id.loginStatusTV);
        callbackManager=CallbackManager.Factory.create();

        accessTokenTracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        loginButton.setReadPermissions("email","public_profile");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
           @Override
           public void onSuccess(LoginResult loginResult) {

               Profile profile=Profile.getCurrentProfile();
               nextActivity(profile);
               Toast.makeText(getBaseContext(),"Successfully Login",Toast.LENGTH_LONG).show();
               loginStatusTv.setText("Successfully Login");
           }

           @Override
           public void onCancel() {
             loginStatusTv.setText("Login Cancelled");
           }

           @Override
           public void onError(FacebookException error) {
             loginStatusTv.setText("Error");
           }
       });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Profile profile=Profile.getCurrentProfile();
        nextActivity(profile);
    }

    @Override
    protected void onPause() {
        super.onPause();
        accessTokenTracker.stopTracking();
        profileTracker.startTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void nextActivity(Profile profile) {
        if (profile != null){
            Intent showDetailsIntent = new Intent(MainActivity.this, LoginActivity.class);
            showDetailsIntent.putExtra("fname", profile.getFirstName());
            showDetailsIntent.putExtra("lname", profile.getLastName());
            showDetailsIntent.putExtra("profilePic",profile.getProfilePictureUri(200,200).toString());
            startActivity(showDetailsIntent);
            finish();
    }
    }

}
