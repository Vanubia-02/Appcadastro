package com.example.appcadastro.DAO;

import com.example.appcadastro.Model.User;
import com.example.appcadastro.helper.DBHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

public class UserDao {

    private User user;
    private DBHelper db;

    public UserDao(Context ctx, User user) {
        this.user = user;
        this.db = new DBHelper(ctx);
    }

    public void signUp(){
        SQLiteDatabase dbLite = this.db.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("email", user.getEmail());
        content.put("password", user.getPassword());

        //Defino a "tabela", oq substituirá se houver valor nulo, e os valores
        long id = dbLite.insert("user", null, content);

        //dbLite.execSQL(sql);
    }

    public boolean signUpVality(){
        SQLiteDatabase db = this.db.getReadableDatabase();

        //Especifico o que quero que retorne.
        String[] projection = {
                "email",
                "password"
        };

        // Define o filtro
        // Onde WHERE selection = selectionArgs
        String selection = "email = ?";
        String[] selectionArgs = {user.getEmail()};

        // Pelo que e como eu ordeno os valores
        String sortOrder =
                "name DESC";

        //Executo o query
        Cursor cursor = db.query(
                "user",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        // Caso haja algum, retorno true
        if(cursor.getCount()>0){
            return true;
        }

        return false;
    }
}
