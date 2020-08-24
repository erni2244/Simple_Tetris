package Scena;

import Figury.Figura;
import Figury.Kropka;

public class Scena extends Figura {

    int wymiar_x; //wymiar x całej sceny
    int wymiar_y; //wymiar y całej sceny

    public Scena(int x, int y){
        wymiar_x=x;
        wymiar_y=y;
        //setWielkosc(0);
    }




    public void additem(){
        //tu upadłe elemęty

    }

    public int getWymiar_x(){ return wymiar_x; }
    public int getWymiar_y(){ return wymiar_y; }

}
