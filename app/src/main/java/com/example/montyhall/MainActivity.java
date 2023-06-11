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

    @SuppressLint("StaticFieldLeak")
    private static ImageView left;
    @SuppressLint("StaticFieldLeak")
    private static ImageView middle;
    @SuppressLint("StaticFieldLeak")
    private static ImageView right;

    //texts
    @SuppressLint("StaticFieldLeak")
    private static TextView eredmeny;
    private TextView jatekSzama;
    private TextView wins;



    private int nyertesSzam;



    private static boolean nyitva;

    private static int nyeresekSzama;
    private static int jatekokSzamaInt;

    private Kezelo kezelo;
    private boolean ujJatek;


    //getters
    public static ImageView getLeft(){
        return left;
    }

    public static ImageView getMiddle(){
        return middle;
    }

    public static ImageView getRight(){
        return right;
    }

    public static TextView getEredmeny(){
        return eredmeny;
    }

    public static boolean getNyitva(){
        return nyitva;
    }

    public static void setNyitva(boolean l){
        nyitva = l;

    }

    public static void nyeresekSzamaNovel(){
        nyeresekSzama++;
    }




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
        Button megtart = findViewById(R.id.megtartBtn);
        megtart.setOnClickListener(this);

        //csere gomb
        Button csere = findViewById(R.id.csereBtn);
        csere.setOnClickListener(this);

        //kivalaszt gomb
        Button kivalaszt = findViewById(R.id.kivalasztBtn);
        kivalaszt.setOnClickListener(this);

        //reset gomb
        Button reset = findViewById(R.id.resetBtn);
        reset.setOnClickListener(this);

        //eredmenyText
        eredmeny = findViewById(R.id.eredmenyText);

        //jatek szama
        jatekSzama = findViewById(R.id.jatekSzamaText);

        //wins
        wins = findViewById(R.id.nyeresekSzamaText);

        //kezdeti beallitasok
        nyitva = false;
        kezelo = new Kezelo();
        Random random = new Random();
        nyertesSzam = random.nextInt(3);
        kezelo.setNyertes(nyertesSzam);
        ujJatek = false;

    }


    @Override
    public void onClick(View view) {

        //elso fazis
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

        //masodik fazis
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

    @SuppressLint("SetTextI18n")
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