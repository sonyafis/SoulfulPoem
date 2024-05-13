package com.example.practica_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "appdatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper instance;
    private Connection connection;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, login TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement schema migration if needed
        db.execSQL("ALTER TABLE users ADD COLUMN new_column TEXT");
    }

    public long insertUser(User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("login", user.getLogin());
        values.put("password", user.getPassword());

        long newRowId = db.insert("users", null, values);
        db.close();
        return newRowId;
    }



    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Установление соединения с базой данных, если оно ещё не установлено или закрыто
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdatabase", "root", "");
            } catch (SQLException e) {
                // Обработка исключения и вывод сообщения об ошибке
                Log.e("DBHelper", "Ошибка при установлении соединения с базой данных", e);
                throw e; // Передача исключения вызывающему методу
            }
        }
        return connection;
    }

}
