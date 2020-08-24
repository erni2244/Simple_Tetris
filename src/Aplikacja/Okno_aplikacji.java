package Aplikacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno_aplikacji extends JFrame implements KeyListener {


    private static int ilosc_pionowo=16;
    private static int liosc_poziomo=8;
    private static int wielkosc_kratki=30;
    Gra gra=new Gra(liosc_poziomo,ilosc_pionowo);
    Siatka siatka=new Siatka(liosc_poziomo,ilosc_pionowo,wielkosc_kratki);
    Menu menu=new Menu();

    public Okno_aplikacji(){
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int a=menu.getWidth();
        setSize(wielkosc_kratki*liosc_poziomo+15+a+15,wielkosc_kratki*ilosc_pionowo+40);
        setLocation(200,200);
        setVisible(true);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);                         //KeyListener traci Focus przez ActionListenera i trzeba ustawić go na stałe ręcznie

        this.add(siatka,BorderLayout.CENTER);
        this.add(menu, BorderLayout.LINE_END);
        gra.dodaj_elemet();
        siatka.setwektor_klocka(gra.getvectorfigurki());


        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean czy_gra_dalej=true;
            while(true)
                try {
                    Thread.sleep(300, 0);
                    if(menu.sprawdz_status_start()==true && czy_gra_dalej==true) {
                        if (!gra.przesun_klocek_w_dol())
                            rysuj_na_nowo();
                        else
                            czy_gra_dalej = false;
                    }
                    if (menu.sprawdz_status_restart()){
                        gra.restart_gra();
                        rysuj_na_nowo();
                        menu.restart_done();
                        czy_gra_dalej=true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    void rysuj_na_nowo(){
        menu.ustaw_wynik(gra.getwynik());
        siatka.setwektor_klocka(gra.getvectorfigurki());
        siatka.setwektor_sceny(gra.getvectorsceny());
        siatka.repaint();
    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int c=keyEvent.getKeyCode();
        //JOptionPane.showMessageDialog(null,"Nacisnąłeś: "+c);
        if(c==37){ gra.przesun_klocek_w_lewo(); rysuj_na_nowo();}
        if(c==39){ gra.przesun_klocek_w_prawo(); rysuj_na_nowo();}
    }

}
