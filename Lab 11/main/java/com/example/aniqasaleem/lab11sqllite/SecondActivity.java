package com.example.aniqasaleem.lab11sqllite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase sqLiteDatabase;
    EditText Rollno,Name;

    Button update, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Rollno = findViewById(R.id.editText);
        Name= findViewById(R.id.editText2);
        update= findViewById(R.id.button);
        delete= findViewById(R.id.button2);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);

    }
}
