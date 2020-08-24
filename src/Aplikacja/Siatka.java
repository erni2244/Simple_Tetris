package Aplikacja;

import Figury.Figura;
import Figury.Punkt;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Siatka extends JPanel {
    int spacing =1;
    int size_element;
    int ilosc_x;
    int ilosc_y;
    Figura nowy_klocek=new Figura();
    Figura nowy_obszar_zajety_sceny=new Figura();

    public Siatka(int x,int y,int size){
        ilosc_x=x;
        ilosc_y=y;
        size_element=size;
    }


    public void setwektor_klocka(Vector<Punkt> a){
        nowy_klocek.setWspolzedne_figorki(a);
    }

    public void setwektor_sceny(Vector<Punkt> a){
        nowy_obszar_zajety_sceny.setWspolzedne_figorki(a);
    }


    public void paintComponent(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,size_element*ilosc_x,size_element*ilosc_y);
        g.setColor(Color.white);

        for(int i=0;i<ilosc_x;i++){
            for(int j=0;j<ilosc_y;j++){
                g.fillRect(spacing+i*size_element,spacing+j*size_element, size_element-2*spacing,size_element-2*spacing);
            }
        }
        for(int i=0;i<nowy_klocek.getWielkosc();i++) {
            g.setColor(Color.blue);
            g.fillRect(spacing+nowy_klocek.getWspolzedna_X_danego_punktu(i)*size_element,spacing+nowy_klocek.getWspolzedna_Y_danego_punktu(i)*size_element, size_element-2*spacing,size_element-2*spacing);
        }
        for(int i=0;i<nowy_obszar_zajety_sceny.getWielkosc();i++) {
            g.setColor(Color.cyan);
            g.fillRect(spacing+nowy_obszar_zajety_sceny.getWspolzedna_X_danego_punktu(i)*size_element,spacing+nowy_obszar_zajety_sceny.getWspolzedna_Y_danego_punktu(i)*size_element, size_element-2*spacing,size_element-2*spacing);
        }


    }
}
