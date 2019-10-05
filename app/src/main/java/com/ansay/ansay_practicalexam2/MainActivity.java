package com.ansay.ansay_practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8;
    EditText t01;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        c7 = findViewById(R.id.checkBox7);
        c8 = findViewById(R.id.checkBox8);
        t01 = findViewById(R.id.t1);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

    }

    public void writeData (View v){
        String data9 = t01.getText().toString()+"";

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data2.txt", MODE_PRIVATE);
            writer.write(data9.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "Subject not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "Subject not found");
            }
        }
        writer = null;

        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);

            if (c1.isChecked()){
                writer.write((c1.getText().toString()+',').getBytes());
            }
            if (c2.isChecked()){
                writer.write((c2.getText().toString()+',').getBytes());
            }
            if (c3.isChecked()){
                writer.write((c3.getText().toString()+',').getBytes());
            }
            if (c4.isChecked()){
                writer.write((c4.getText().toString()+',').getBytes());
            }
            if (c5.isChecked()){
                writer.write((c5.getText().toString()+',').getBytes());
            }
            if (c6.isChecked()){
                writer.write((c6.getText().toString()+',').getBytes());
            }
            if (c7.isChecked()){
                writer.write((c7.getText().toString()+',').getBytes());
            }
            if (c8.isChecked()){
                writer.write((c8.getText().toString()+',').getBytes());
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "Subject not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "Subject not found");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }
}
