package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase.db.DbHelper;
import com.example.sqlitedatabase.model.Student;

public class UpdateActivity extends AppCompatActivity {

    private DbHelper dbHelper;
    private EditText etName, etNim;
    private Button btnUpdate;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DbHelper(this);

        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        btnUpdate = findViewById(R.id.btn_submit);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("user");

        etName.setText(student.getName());
        etNim.setText(student.getNim());

        btnUpdate.setOnClickListener((View v) -> {
            dbHelper.updateUser(student.getId(), etNim.getText().toString(), etName.getText().toString());
            Toast.makeText(UpdateActivity.this, "Updated berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}