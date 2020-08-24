package Aplikacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {

    private boolean status_start=false;
    private boolean status_restart=false;
    JButton button_start;
    JButton button_reset;
    JLabel wynik;

    public Menu(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        make_elements();
        this.setSize(new Dimension(100,120));
        this.setMaximumSize(new Dimension(100,120));
    }


    public boolean sprawdz_status_start(){ return status_start; }
    public boolean sprawdz_status_restart(){ return status_restart; }
    public void restart_done(){ status_restart=false; }

    private void start_click(){ status_start=true; button_start.setVisible(false);}
    private void reset_click(){ status_restart=true; status_start=false; button_start.setVisible(true);}



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source=actionEvent.getSource();
        if(source==button_start)
            start_click();
        else if(source==button_reset)
            reset_click();
    }

    private void make_elements(){
        button_start=new JButton("Start");
        button_reset=new JButton("Reset");
        wynik=new JLabel("Wynik: 0");
        button_start.setSize(new Dimension(100,30));
        button_reset.setSize(new Dimension(100,30));
        wynik.setSize(new Dimension(100,30));
        button_start.addActionListener(this);
        button_reset.addActionListener(this);
        this.add(button_start);
        this.add(button_reset);
        this.add(wynik);
    }

    public void ustaw_wynik(int a){
        wynik.setText("Wynik: "+a);
    }



}
