package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //kepek
    private ImageView left;
    private ImageView middle;
    private ImageView right;

    //texts
    private TextView eredmeny;
    private TextView jatekSzama;
    private TextView wins;


    //Buttons
    private Button csere;
    private Button megtart;
    private Button kivalaszt;

    //bool valtozo
    private String selected;


    private int nyertesSzam;


    private String nyertesKartya;

    private boolean nyitva;

    private int nyeresekSzama;
    private int jatekokSzamaInt;


    //Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bal kartya
        left = findViewById(R.id.leftImg);
        left.setOnClickListener(this);

        //kozepso kartya
        middle = findViewById(R.id.middleImg);
        middle.setOnClickListener(this);

        //jobb kartya
        right = findViewById(R.id.rightImg);
        right.setOnClickListener(this);

        //megtart gomb
        megtart = findViewById(R.id.megtartBtn);
        megtart.setOnClickListener(this);

        //csere gomb
        csere = findViewById(R.id.csereBtn);
        csere.setOnClickListener(this);

        //kivalaszt gomb
        kivalaszt = findViewById(R.id.kivalasztBtn);
        kivalaszt.setOnClickListener(this);

        //eredmenyText
        eredmeny = findViewById(R.id.eredmenyText);

        //jatek szama
        jatekSzama = findViewById(R.id.jatekSzamaText);

        //wins
        wins = findViewById(R.id.nyeresekSzamaText);

        selected = "nincs";
        nyitva = false;

        String[] valasztek = {"left", "middle", "right"};
        Random random = new Random();
        nyertesSzam = random.nextInt(3);
        nyertesKartya = valasztek[nyertesSzam];


    }


    @Override
    public void onClick(View view) {
        if(!nyitva){
            if (view.getId() == R.id.leftImg) {
                setEmptyView();
                Toast.makeText(this, "bal", Toast.LENGTH_SHORT).show();
                left.setImageResource(R.mipmap.kijelolt);
                selected = "left";

            } else if (view.getId() == R.id.middleImg) {
                setEmptyView();
                Toast.makeText(this, "kozepso", Toast.LENGTH_SHORT).show();
                middle.setImageResource(R.mipmap.kijelolt);
                selected = "middle";
            } else if (view.getId() == R.id.rightImg) {
                setEmptyView();
                Toast.makeText(this, "jobb", Toast.LENGTH_SHORT).show();
                right.setImageResource(R.mipmap.kijelolt);
                selected = "right";
            } else if (view.getId() == R.id.kivalasztBtn) {

                if (selected.equals( "nincs")) {
                    Toast.makeText(this, "Plese select", Toast.LENGTH_SHORT).show();
                } else {
                    //kinyit()
                    Kinyit();
                    nyitva = true;
                    //Toast.makeText(this,"kinyit",Toast.LENGTH_SHORT).show();

                }
            }

        }
        //masodik fazis
        else{
            if (view.getId() == R.id.megtartBtn){
                Megtart();
                UjJatek();
            }
            else if(view.getId() == R.id.csereBtn){
                Csere();
                UjJatek();
            }




        }




        //Toast.makeText(this,"Plese select",Toast.LENGTH_SHORT).show();


    }



    public void Kinyit(){

        if(selected.equals( "left")){
            //ha eltalta a baloldalit
            if(nyertesKartya.equals( selected) || nyertesKartya.equals( "middle")){
                //jobb oldali kinyit
                right.setImageResource(R.mipmap.kecske);
            }
            else{
                middle.setImageResource(R.mipmap.kecske);
            }
        }
        else if(selected.equals( "middle")){
            if(nyertesKartya.equals( selected) || nyertesKartya.equals( "left")){
                right.setImageResource(R.mipmap.kecske);
            }
            else{
                left.setImageResource(R.mipmap.kecske);
            }
        }
        else if(selected.equals( "right")){
            if(selected.equals( nyertesKartya) || nyertesKartya.equals( "middle")){
                left.setImageResource(R.mipmap.kecske);
            }
            else{
                middle.setImageResource(R.mipmap.kecske);
            }
        }

    }

    public void Megtart(){
        jatekokSzamaInt++;
        if(nyertesKartya.equals(selected)){
            nyeresekSzama++;
        }
        setAllKecske();

        if(nyertesKartya.equals("left")){
            left.setImageResource(R.mipmap.kocsi);
        } else if (nyertesKartya.equals("middle")) {
            middle.setImageResource(R.mipmap.kocsi);

        } else if (nyertesKartya.equals("right")) {
            right.setImageResource(R.mipmap.kocsi);

        }

    }

    public void Csere(){
        jatekokSzamaInt++;
        if( !(nyertesKartya.equals(selected))){
            nyeresekSzama++;
        }
        setAllKecske();
        if(nyertesKartya.equals("left")){
            left.setImageResource(R.mipmap.kocsi);
        } else if (nyertesKartya.equals("middle")) {
            middle.setImageResource(R.mipmap.kocsi);

        } else if (nyertesKartya.equals("right")) {
            right.setImageResource(R.mipmap.kocsi);

        }


    }


    public void UjJatek(){
        selected = "nincs";
        nyitva = false;
        String jtk = "Jatekok szama: " + jatekokSzamaInt;
        jatekSzama.setText(jtk);
        String winks = "Wins: "+nyeresekSzama;
        wins.setText(winks);


        String[] valasztek = {"left", "middle", "right"};
        Random random = new Random();
        nyertesSzam = random.nextInt(3);
        nyertesKartya = valasztek[nyertesSzam];


    }





    public void setEmptyView(){
        left.setImageResource(R.mipmap.megforditott);
        middle.setImageResource(R.mipmap.megforditott);
        right.setImageResource(R.mipmap.megforditott);

    }

    public void setAllKecske(){
        left.setImageResource(R.mipmap.kecske);
        middle.setImageResource(R.mipmap.kecske);
        right.setImageResource(R.mipmap.kecske);


    }
}