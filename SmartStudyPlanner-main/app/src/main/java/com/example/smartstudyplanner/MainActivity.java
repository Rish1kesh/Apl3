package com.example.smartstudyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask, btnViewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = findViewById(R.id.btnAddTask);
        btnViewTask = findViewById(R.id.btnViewTask);

        btnAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(intent);

        });

        btnViewTask.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewTaskActivity.class);
            startActivity(intent);
        });
    }
}