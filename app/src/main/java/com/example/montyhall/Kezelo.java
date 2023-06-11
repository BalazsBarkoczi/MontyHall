package com.example.montyhall;

import java.util.ArrayList;
import java.util.Random;

public class Kezelo {

    public ArrayList<Kartya> kartyak;
    private boolean vanSelected;

    public Kezelo(){
        kartyak = new ArrayList<>();
        vanSelected = false;
        //ird at
        kartyak.add(new Left("left"));
        kartyak.add(new Middle("middle"));
        kartyak.add(new Right("right"));
    }


    //nyertes kartya set
    public void setNyertes(int i){
        kartyak.get(i).nyertes();
    }


    //unselect
    public void setUnselected(){
        for(Kartya kartya : kartyak){
            kartya.deSelect();
        }
    }


    //select kartya
    public void Select(int index){
        kartyak.get(index).select();
        vanSelected = true;
    }

    public void AllKirajzol(){
        for(Kartya kartya : kartyak){
            kartya.Kirajzol();
        }

    }


    //amikor kivalasztas van random kinyit egy kecsket
    public void Kivalasztas(){
        Random random = new Random();
        int num = random.nextInt(4) + 1;
        for(int i = 0; i < 3; i++){
            int index = (num+i) % 3;
            if( !kartyak.get(index).isNyertes() && !kartyak.get(index).isSelected()){
                kartyak.get(index).kecskeNyitas();
                kartyak.get(index).nyitott();
                break;
            }
        }

    }


    public boolean isVanSelected() {
        return vanSelected;
    }

    public void setVanSelected(boolean vanSelected) {
        this.vanSelected = vanSelected;
    }
}
