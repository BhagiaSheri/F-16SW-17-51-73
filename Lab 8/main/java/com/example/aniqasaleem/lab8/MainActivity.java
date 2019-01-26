package com.example.aniqasaleem.lab8;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver mreceiver;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= 23) {
            int permission = checkSelfPermission(Manifest.permission.RECEIVE_SMS);
            if (permission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 2);
            } else {
                Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();
            }
        }


        IntentFilter in = new IntentFilter();
        in.addAction("android.provider.Telephony.SMS_RECEIVER");


         mreceiver = new BroadcastReceiver() {
             @Override
             public void onReceive(Context context, Intent intent) {
                 String msg = intent.getStringExtra("msg");
                 if(msg.contains("HELLO")|| msg.contains("Hello")){
                     Toast.makeText(getApplicationContext(),"Greetings!",Toast.LENGTH_LONG).show();
                 }

             }
         };
        registerReceiver(mreceiver,in);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 2:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Permission Granted!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
