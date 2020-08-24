package Figury;

import java.util.Vector;

public class Figura {
    protected Vector<Punkt> wspolzedne_figorki = new Vector<>();


    public int getWielkosc(){ return wspolzedne_figorki.size(); }

    public Vector<Punkt> getWspolzedne_figorki(){ return wspolzedne_figorki; }
    public int getWspolzedna_X_danego_punktu(int i){ return wspolzedne_figorki.get(i).getWspolzedna_x();}
    public int getWspolzedna_Y_danego_punktu(int i){ return wspolzedne_figorki.get(i).getWspolzedna_y();}
    public void setWspolzedne_figorki(Vector<Punkt> a){ wspolzedne_figorki=a; }
    public void setWspolzedna_X_danego_punktu(int i,int x){ wspolzedne_figorki.get(i).setWspolzedna_x(x);}
    public void setWspolzedna_Y_danego_punktu(int i,int y){ wspolzedne_figorki.get(i).setWspolzedna_y(y);}
    public void add_wszystkie_elementy(Vector<Punkt> ve){wspolzedne_figorki.addAll(ve);}
    public void add_jeden_element(Punkt p){wspolzedne_figorki.add(p);}
    public void remove_dany_punkt(int a){wspolzedne_figorki.remove(a);}
}
