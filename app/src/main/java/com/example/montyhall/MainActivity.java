package com.example.montyhall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //kepek
    private ImageView left;
    private ImageView middle;
    private ImageView right;

    //texts
    private TextView eredmeny;


    //Buttons
    private Button csere;
    private  Button megtart;

    //bool valtozo
    private String melyik;




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

        melyik = "nincs";

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.leftImg ){
            setEmptyView();


            Toast.makeText(this,"bal",Toast.LENGTH_SHORT).show();
            left.setImageResource(R.mipmap.kijelolt);

        }
        else if(view.getId() == R.id.middleImg){
            setEmptyView();
            Toast.makeText(this,"kozepso",Toast.LENGTH_SHORT).show();
            middle.setImageResource(R.mipmap.kijelolt);
        }
        else if(view.getId() == R.id.rightImg){
            setEmptyView();
            Toast.makeText(this,"jobb",Toast.LENGTH_SHORT).show();
            right.setImageResource(R.mipmap.kijelolt);
        }

    }

    public void setEmptyView(){
        left.setImageResource(R.mipmap.megforditott);
        middle.setImageResource(R.mipmap.megforditott);
        right.setImageResource(R.mipmap.megforditott);

    }
}