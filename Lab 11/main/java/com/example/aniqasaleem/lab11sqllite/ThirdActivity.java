package com.example.aniqasaleem.lab11sqllite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText rNo, nam;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
         rNo= findViewById(R.id.editText3);
         nam = findViewById(R.id.editText4);
         save = findViewById(R.id.button3);
         save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent4 = new Intent(ThirdActivity.this,MainActivity.class);
        startActivity(intent4);
    }
}
