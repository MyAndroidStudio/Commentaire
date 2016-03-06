package com.example.hachem.commentaire;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hachem on 15/02/2016.
 */
public class Base extends SQLiteOpenHelper
{
    public String Commentaire_Create="create table commentaire( id integer not null  primary key,contenu text not null ,date text not null);";
    public String Commentaire_Drop="drop table if exists commentaire";
    public Base(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Commentaire_Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(Commentaire_Drop);
        onCreate(db);
    }
}
