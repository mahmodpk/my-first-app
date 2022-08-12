package com.example.myjava;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        AppCompatButton btn = findViewById(R.id.btn1);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

           btn.setOnClickListener(v -> {
               Intent intent = new Intent(getApplicationContext(),NoteActivity.class);
               startActivity(intent);
               Toast.makeText(getApplicationContext(),"next actvity",Toast.LENGTH_SHORT).show();
           });

    }
}