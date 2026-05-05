package com.example.smartstudyplanner;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViewTaskActivity extends AppCompatActivity {

    TextView tvTasks;
    DatabaseHelper databaseHelper;
    Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        tvTasks = findViewById(R.id.tvTasks);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
        databaseHelper = new DatabaseHelper(this);

        Cursor cursor = databaseHelper.getAllTasks();

        if (cursor.getCount() == 0) {
            tvTasks.setText("No study tasks found.");
        } else {
            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {
                data.append("Subject: ").append(cursor.getString(1)).append("\n");
                data.append("Topic: ").append(cursor.getString(2)).append("\n");
                data.append("Date: ").append(cursor.getString(3)).append("\n");
                data.append("--------------------------\n");
            }

            tvTasks.setText(data.toString());
        }

        cursor.close();
    }
}