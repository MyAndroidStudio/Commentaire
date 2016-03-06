package com.example.hachem.commentaire;

/**
 * Created by Hachem on 15/02/2016.
 */
public class Commentaire
{
    public int id;
    public String contenu;
    public String date;
    public Commentaire()
    {
        super();
    }
    public Commentaire(int id,String contenu,String date)
    {
        super();
        this.id=id;
        this.contenu=contenu;
        this.date=date;
    }

    public int getId()
    {
        return id;
    }
    public void  setId(int id)
    {
         this.id=id;
    }
    public String getContenu()
    {
        return contenu;
    }
    public void  setContenu(String contenu)
    {
        this.contenu=contenu;
    }
    public String getDate()
    {
        return date;
    }
    public void  setDate(String date)
    {
        this.date=date;
    }
}
