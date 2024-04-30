package com.kps;

/**
 * Luokka Main on Kivi-paperi-sakset-pelin pääohjelma.
 *
 * @author Ira Dook
 */
public class Main {

    /**
     * Pääohjelma, joka suorittaa Kivi-paperi-sakset-pelin.
     *
     * @param args Käynnistysargumentit.
     */
    public static void main(String[] args) {
        Peli peli = new Peli();
        peli.pelaa();
    }
}
