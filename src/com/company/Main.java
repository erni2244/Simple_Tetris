package com.company;

import Aplikacja.Okno_aplikacji;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Okno_aplikacji();
            }
        });
    }
}
