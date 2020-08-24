package Figury;

import java.util.Random;

public class Losowa_figura extends Figura{

    public Losowa_figura(int szer_sceny){
        Punkt punkt;
        punkt=new Punkt(szer_sceny/2,0);
        add_jeden_element(punkt);
        for(int i=0,j=losuj_ilosc();i<j;i++) {
            punkt = losuj_następny_punkt();
            if (!sprawdz_czy_istnieje_punkt(punkt))
                add_jeden_element(punkt);
            else
                i--;
        }
    }

    private Punkt losuj_następny_punkt(){
        Punkt punkt;
        int nr=losuj_liczbe_ze_zbioru(getWielkosc());
        int kierunek= losuj_liczbe_ze_zbioru(2);
        int strona=losuj_liczbe_ze_zbioru(2)*2-1;
        punkt=new Punkt(getWspolzedna_X_danego_punktu(nr)+kierunek*strona,getWspolzedna_Y_danego_punktu(nr)+(-(kierunek-1))*strona );
        return punkt;
    }

    private boolean sprawdz_czy_istnieje_punkt(Punkt punkt){
        for(int i=0;i<getWielkosc();i++)
            if(punkt.getWspolzedna_x()==getWspolzedna_X_danego_punktu(i) && punkt.wspolzedna_y==getWspolzedna_Y_danego_punktu(i))
                return true;
            return false;
    }

    private int losuj_ilosc(){
        Random random=new Random();
        return random.nextInt(4);
    }

    private int losuj_liczbe_ze_zbioru(int zbior){
        Random random=new Random();
        return random.nextInt(zbior);
    }
}
