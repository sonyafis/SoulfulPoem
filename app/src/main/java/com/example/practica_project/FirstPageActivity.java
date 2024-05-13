package com.example.practica_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class FirstPageActivity extends AppCompatActivity {

    private TextInputLayout nameTextInputLayout;
    private TextInputLayout loginTextInputLayout;
    private TextInputLayout passwordTextInputLayout;
    private DBHelper dbHelper;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        nameTextInputLayout = findViewById(R.id.text_input_layout_name);
        loginTextInputLayout = findViewById(R.id.text_input_layout_login);
        passwordTextInputLayout = findViewById(R.id.text_input_layout_password);
        dbHelper = DBHelper.getInstance(this);
        dbHelper = DBHelper.getInstance(this); // Изменение инициализации DBHelper без указания лишних параметров
        //dbHelper.open(); // Удаление вызова метода open, так как SQLiteOpenHelper уже управляет открытием и закрытием соединения

        submitButton = findViewById(R.id.button3);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTextInputLayout.getEditText().getText().toString();
                String login = loginTextInputLayout.getEditText().getText().toString();
                String password = passwordTextInputLayout.getEditText().getText().toString();

                User user = new User(name, login, password);
                long newRowId = dbHelper.insertUser(user);

                if (newRowId != -1) {
                    // Успешно добавлено
                    showToast("Новый пользователь успешно добавлен в базу данных.");
                    Intent intent = new Intent(FirstPageActivity.this, BasicActivity.class);
                    startActivity(intent);
                } else {
                    // Ошибка при добавлении
                    showToast("Ошибка при добавлении пользователя.");
                }
            }
        });
    }

    // Вспомогательный метод для вывода Toast сообщений
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show(); // Замена FirstPageActivity.this на this
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();// Закрытие соединения с базой данных при уничтожении активности
    }
}
