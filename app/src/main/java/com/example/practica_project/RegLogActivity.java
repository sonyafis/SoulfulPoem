package com.example.practica_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegLogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglog);

        Button button = findViewById(R.id.button_register_reglog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegLogActivity.this, FirstPageActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button_input_reglog);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegLogActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
    }
}
