package com.example.hp.lab4_task2plus1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylelist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] names ={"Aniqa", "Bhagia", "Pooja", "Mashal", "Hani", "Ammna", "Anabia", "Touqeer", "Anmol"};
        recyclerView.setAdapter(new RecyclerAdapter(names));

    }
}
