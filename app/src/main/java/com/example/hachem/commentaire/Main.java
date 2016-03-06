package com.example.hachem.commentaire;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.Vector;

public class Main extends Activity {


    public CommentaireManager cm;
    public Button boutonAjouter;
    public Button boutonAfficher;
    public EditText editText;
    public TextView textView;

    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        boutonAjouter=(Button)findViewById(R.id.boutonAjouter);
        boutonAfficher=(Button)findViewById(R.id.boutonAffivher);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        cm=new CommentaireManager(this);
        cm.open();
        afficher();
        boutonAjouter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                String contenu=editText.getText().toString();
               if(!contenu.equals(""))
               {
                  Commentaire c=new Commentaire(1,contenu,new Date().toLocaleString());

                   cm.ajouter(c);
                   afficher();
                   editText.setText("");
               }
            }
        });

        boutonAfficher.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                    textView.setText("");
                    cm.supprimertout();

            }
        });
    }

    public void afficher()
    {
        Vector v=cm.afficher();
        String ch="";
        String s;
        for(int i=v.size()-1;i>=0;i--)
        {
            Commentaire c=(Commentaire)v.elementAt(i);
            s="\t"+c.getContenu()+"\n\t"+c.getDate()+"\n_________\n";
           textView.setText(ch+s);
            ch=ch+s;
        }
    }
}
