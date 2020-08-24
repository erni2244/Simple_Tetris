package Figury;

public class Punkt {
    int wspolzedna_x;
    int wspolzedna_y;

    public Punkt(int x,int y){
        wspolzedna_x=x;
        wspolzedna_y=y;
    }

    public int getWspolzedna_x(){
        return wspolzedna_x;
    }
    public int getWspolzedna_y(){ return wspolzedna_y; }
    public void setWspolzedna_x(int x){ wspolzedna_x=x; }
    public void setWspolzedna_y(int y){ wspolzedna_y=y; }
}
