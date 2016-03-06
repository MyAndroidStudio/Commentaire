package com.example.hachem.commentaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by Hachem on 15/02/2016.
 */
public class CommentaireManager
{
    public Base b;
    public SQLiteDatabase db;

    public CommentaireManager(Context context)
    {
        b=new Base(context,"commentaire",null,1);

    }

    public void open()
    {

        db=b.getWritableDatabase();
   }
    public void close()
    {
       db.close();
    }
    public void ajouter(Commentaire c)
    {
        ContentValues v=new ContentValues();
        //v.put("id",c.getId());
        v.put("contenu",c.getContenu());
        v.put("date",c.getDate());
        db.insert("commentaire", null, v);
    }
    public void supprimer(int id)
    {
        db.delete("commentaire", "id=?", new String[]{String.valueOf(id)});
    }
    public void supprimertout()
    {
        db.delete("commentaire", null, null);
    }
    public Vector afficher()
    {
        Cursor c = db.rawQuery("select * from commentaire ", null);
        Vector v= new Vector<>();
        while (c.moveToNext())
        {
            int id = c.getInt(0);
            String contenu = c.getString(1);
            String  date = c.getString(2);
            Commentaire m = new Commentaire (id, contenu, date);
            v.addElement(m);
        }
        c.close();
        return v;
    }


}
