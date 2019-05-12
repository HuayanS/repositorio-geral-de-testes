package com.example.huayansantiago.telas_cad_loguin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@androidx.annotation.Nullable Context context {
        super(context, "ULoguin.db", null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Usuario (email text primary key, senha text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuario");

    }
    public boolean insert (String email,String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("senha",senha);
        long ins = db.insert("Usuario",null,contentValues);
        if (ins == -1) return false;
        else return true;
    }
    public Boolean checkemail(String email){
    SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Usuario where email=?",new String[]{email});
        if(cursor.getCount()<0) return false;
        else return true ;
    }
}
