package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    //kepek

    public static ImageView left;
    public static ImageView middle;
    public static ImageView right;

    //texts
    public static TextView eredmeny;
    private TextView jatekSzama;
    private TextView wins;


    //Buttons
    private Button csere;
    private Button megtart;
    private Button kivalaszt;
    private Button reset;

    //bool valtozo
    private String selected;


    private int nyertesSzam;




    public static boolean nyitva;

    public static int nyeresekSzama;
    public static int jatekokSzamaInt;

    private Kezelo kezelo;
    private boolean ujJatek;


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

        //reset gomb
        reset = findViewById(R.id.resetBtn);
        reset.setOnClickListener(this);

        //eredmenyText
        eredmeny = findViewById(R.id.eredmenyText);

        //jatek szama
        jatekSzama = findViewById(R.id.jatekSzamaText);

        //wins
        wins = findViewById(R.id.nyeresekSzamaText);

        selected = "nincs";
        nyitva = false;

        kezelo = new Kezelo();
        Random random = new Random();
        nyertesSzam = random.nextInt(3);
        kezelo.setNyertes(nyertesSzam);
        //nyertesKartya = valasztek[nyertesSzam];

        ujJatek = false;





    }


    @Override
    public void onClick(View view) {
        ////uj
        if(!nyitva) {
            if(!ujJatek){
                ujJatek = true;
                setEmptyView();
                eredmeny.setText("");
            }
            if (view.getId() == R.id.leftImg) {


                kezelo.setUnselected();
                kezelo.Select(0);
                kezelo.AllKirajzol();
            } else if (view.getId() == R.id.middleImg) {
                kezelo.setUnselected();
                kezelo.Select(1);
                kezelo.AllKirajzol();

            } else if (view.getId() == R.id.rightImg) {
                kezelo.setUnselected();
                kezelo.Select(2);
                kezelo.AllKirajzol();
            } else if (view.getId() == R.id.kivalasztBtn) {
                if (!kezelo.isVanSelected()) {
                    Toast.makeText(this, "Plese select", Toast.LENGTH_SHORT).show();
                } else {
                    kezelo.Kivalasztas();
                    nyitva = true;
                }
            }
        }
        else{

            //megtart
            if(view.getId() == R.id.megtartBtn){
                kezelo.AllKirajzol();
                jatekokSzamaInt++;
                UjJatek();

            }
            //csere
            else if(view.getId() == R.id.csereBtn){
                kezelo.Csere();
                kezelo.AllKirajzol();
                jatekokSzamaInt++;
                UjJatek();
            }
        }
        if(view.getId() == R.id.resetBtn){
            Reset();
        }

    }

    public void UjJatek(){

        nyitva = false;
        String jtk = "Jatekok szama: " + jatekokSzamaInt;
        jatekSzama.setText(jtk);
        String winks = "Wins: "+nyeresekSzama;
        wins.setText(winks);



        Random random = new Random();
        nyertesSzam = random.nextInt(3);
        kezelo.UjJatek();

        kezelo.setNyertes(nyertesSzam);
        ujJatek = false;
        kezelo.setVanSelected(false);

    }

    public void Reset(){
        UjJatek();
        nyeresekSzama = 0;
        jatekokSzamaInt = 0;
        eredmeny.setText("");
        jatekSzama.setText("Jatekok szama: ");
        wins.setText("Wins: ");

    }





    public void setEmptyView(){
        left.setImageResource(R.mipmap.megforditott);
        middle.setImageResource(R.mipmap.megforditott);
        right.setImageResource(R.mipmap.megforditott);

    }


}