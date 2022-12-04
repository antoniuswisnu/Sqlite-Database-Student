package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;
    private EditText etName, etNim;
    private Button btnSubmit, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);

        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        btnSubmit = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNim.getText().toString().isEmpty() || etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Error: Nim dan Nama harus diisi!", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.addUserDetail(etNim.getText().toString(), etName.getText().toString());
                    etName.setText("");
                    etNim.setText("");
                    Toast.makeText(MainActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListStudentsActivity.class);
                startActivity(intent);
            }
        });
    }
}