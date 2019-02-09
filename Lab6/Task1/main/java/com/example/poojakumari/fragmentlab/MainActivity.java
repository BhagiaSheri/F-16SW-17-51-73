package com.example.poojakumari.fragmentlab;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fManager;
    FragmentTransaction fTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            Toast.makeText(getApplicationContext(),"Landscape",Toast.LENGTH_LONG).show();
            addSecond();
        } else {
            // In portrait
            Toast.makeText(getApplicationContext(),"portrait",Toast.LENGTH_LONG).show();
            addFirst();
        }
    }

    public void addFirst(){
        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.fragmentLayout,new FragmentOne());
        fTransaction.commit();


    }

    public void addSecond(){
        fManager = getSupportFragmentManager();
        fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.fragmentLayout,new FragmentTwo());
        fTransaction.commit();
    }
}
