package com.example.smartstudyplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    EditText etSubject, etTopic, etDate;
    Button btnSave;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etSubject = findViewById(R.id.etSubject);
        etTopic = findViewById(R.id.etTopic);
        etDate = findViewById(R.id.etDate);
        btnSave = findViewById(R.id.btnSave);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> {
            String subject = etSubject.getText().toString();
            String topic = etTopic.getText().toString();
            String date = etDate.getText().toString();

            if (subject.isEmpty() || topic.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = databaseHelper.insertTask(subject, topic, date);

                if (inserted) {
                    Toast.makeText(this, "Task Saved Successfully", Toast.LENGTH_SHORT).show();

                    etSubject.setText("");
                    etTopic.setText("");
                    etDate.setText("");
                } else {
                    Toast.makeText(this, "Task Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}