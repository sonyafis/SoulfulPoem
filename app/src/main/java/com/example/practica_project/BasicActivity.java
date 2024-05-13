package com.example.practica_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        Button button = findViewById(R.id.linearlayout_button_basic2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PoemActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.linearlayout_button2_basic);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PoemActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.linearlayout_button4_basic);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PoemActivity.class);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.linearlayout_button3_basic);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PoemActivity.class);
                startActivity(intent);
            }
        });

        Button button5 = findViewById(R.id.linearlayout_button5_basic);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, PoemActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button6 = findViewById(R.id.imageButton_Add);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button7 = findViewById(R.id.imageButton_Profile);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
