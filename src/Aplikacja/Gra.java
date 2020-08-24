package Aplikacja;

import Figury.Figura;
import Figury.Losowa_figura;
import Figury.Punkt;
import Scena.Scena;

import java.util.Vector;

public class Gra {

    private Scena scena;
    private Figura figura_jakas;
    private int wynik=0;

    public Gra(int size_x,int size_y){
        scena=new Scena(size_x,size_y);
        figura_jakas=new Figura();
    }

    private void setwynik(int a){ wynik=a; }
    public int getwynik(){ return wynik; }

    boolean dodaj_elemet(){
        figura_jakas=new Figura();
        Losowa_figura losowa_figura=new Losowa_figura(scena.getWymiar_x());
        figura_jakas.setWspolzedne_figorki(losowa_figura.getWspolzedne_figorki());
        return sprawdz_przegrana();
    }

    //zwraca true gdy koniec gry
    boolean sprawdz_przegrana(){
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            if(sprawdz_kolizje_z_innymi_klockami(0))
                return true;
        return false;
    }

    void add_klocek_do_sceny(){
        scena.add_wszystkie_elementy(figura_jakas.getWspolzedne_figorki());
        sprawdz_czy_pelny_rzad_i_usun();
    }

    boolean zapisz_stary_i_dodaj_nowy(){
        add_klocek_do_sceny();
        return dodaj_elemet();
    }

    public Vector<Punkt> getvectorfigurki(){
        return figura_jakas.getWspolzedne_figorki();
    }
    public Vector<Punkt> getvectorsceny(){return scena.getWspolzedne_figorki();}

    void usun_rzad(int y){
        setwynik(wynik+1);
        for(int i=0;i<scena.getWielkosc();i++)
            if(scena.getWspolzedna_Y_danego_punktu(i)==y){
                scena.remove_dany_punkt(i);
                i--;}                           // !!! to "i--" jest potrzebne bo usuwając zmienia sie rozmaiar tablicy i skraca się pętla i pomija kilka bloczków, a gdy da się szerokosc planszy to wychodzi poza Vector klocków
    }

    void sprawdz_czy_pelny_rzad_i_usun(){
        for(int i=0;i<figura_jakas.getWielkosc();i++)
            if(sprawdz_czy_pelny_rzad_w_punkcie(figura_jakas.getWspolzedna_Y_danego_punktu(i))){
                usun_rzad(figura_jakas.getWspolzedna_Y_danego_punktu(i));
                przesun_wszystkie_klocki_nad_Y_w_dol(figura_jakas.getWspolzedna_Y_danego_punktu(i));
                }
    }

    boolean sprawdz_czy_pelny_rzad_w_punkcie(int y){
        int licznik=0;
        for(int i=0;i<scena.getWielkosc();i++){
            if(scena.getWspolzedna_Y_danego_punktu(i)==y)
                licznik++; }
        return licznik == scena.getWymiar_x();
    }



    boolean przesun_klocek_w_dol(){
        if(!sprawdz_kolizje_podloga())
            for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            figura_jakas.setWspolzedna_Y_danego_punktu(i,figura_jakas.getWspolzedna_Y_danego_punktu(i)+1);//przesuwa o jeden w dół wszystkie punkty klocka
        else
            return zapisz_stary_i_dodaj_nowy();
        return false;
    }

void przesun_wszystkie_klocki_nad_Y_w_dol(int y){
        for(int i=0;i<scena.getWielkosc();i++)
            if(scena.getWspolzedna_Y_danego_punktu(i)<y)
                scena.setWspolzedna_Y_danego_punktu(i,scena.getWspolzedna_Y_danego_punktu(i)+1);
}


    void przesun_klocek_w_prawo(){
        if(sprawdz_lkolizje_ze_sciana(0, 1))
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            figura_jakas.setWspolzedna_X_danego_punktu(i,figura_jakas.getWspolzedna_X_danego_punktu(i)+1);      //przesuwa o jeden w bok wszystkie punkty klocka
    }
    void przesun_klocek_w_lewo(){
        if(sprawdz_lkolizje_ze_sciana(1, 0))
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            figura_jakas.setWspolzedna_X_danego_punktu(i,figura_jakas.getWspolzedna_X_danego_punktu(i)-1);      //przesuwa o jeden w bok wszystkie punkty klocka
    }


    boolean sprawdz_lkolizje_ze_sciana(int left,int right){
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
        if(figura_jakas.getWspolzedna_X_danego_punktu(i)-left<0 || figura_jakas.getWspolzedna_X_danego_punktu(i)+right>=scena.getWymiar_x())
            return false;
        return true;
    }

    boolean sprawdz_kolizje_z_innymi_klockami(int wyprzedzenie_sprawdzenia){
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            for(int j=0;j<scena.getWielkosc();j++)
                if(figura_jakas.getWspolzedna_Y_danego_punktu(i)+wyprzedzenie_sprawdzenia>=scena.getWspolzedna_Y_danego_punktu(j) && figura_jakas.getWspolzedna_X_danego_punktu(i)==scena.getWspolzedna_X_danego_punktu(j))
                    return true;
        return false;
    }

    boolean sprawdz_kolizje_podloga(){
        for(int i=0;i<figura_jakas.getWspolzedne_figorki().size();i++)
            if(figura_jakas.getWspolzedna_Y_danego_punktu(i)+1>=scena.getWymiar_y() || sprawdz_kolizje_z_innymi_klockami(1))
                return true;
        return false;
    }

    public void restart_gra(){
        zapisz_stary_i_dodaj_nowy();
        setwynik(0);
        while (scena.getWielkosc() > 0)
            scena.remove_dany_punkt(0);
    }

}
