package com.kps;

/**
 * Luokka Peli edustaa Kivi-paperi-sakset-peliä.
 *
 * @author Ira Dook
 */
public class Peli {

    /**
     * Pelaaja 1.
     */
    private Pelaaja p1 = new Pelaaja();

    /**
     * Pelaaja 2.
     */
    private Pelaaja p2 = new Pelaaja();

    /**
     * Määrittää, onko peli käynnissä.
     */
    private boolean kaynnissa = true;

    /**
     * Pelattujen kierrosten lukumäärä.
     */
    private int pelatutPelit = 0;

    /**
     * Tasapelien lukumäärä.
     */
    private int tasapelit = 0;

    /**
     * Käynnistää Kivi-paperi-sakset-pelin. Sisältää ohjelman rungon/toiminnot.
     */
    public void pelaa() {
        while(kaynnissa) {
            tulostaTilanne();

            pelaaKierros();

            vertaaValinnat();             

            tarkistaLoppuminen();
        }
    }

    /**
     * Tulostaa pelin tilannetiedot.
     */
    private void tulostaTilanne() {
        System.out.printf("\nErä: %d ================\n", pelatutPelit + 1);
        System.out.printf("Tasapelien lukumäärä: %d\n", tasapelit);
    }

    /**
     * Vertaa pelaajien valintoja ja määrittää voittajan.
     */
    void vertaaValinnat() {

        if (p1.getValinta().equals(p2.getValinta())) {
            tasapelit++;
            System.out.println("\n\t\t Tasapeli \n");
            return;
        }

        if (p1.getValinta().equals("kivi") && p2.getValinta().equals("sakset")
                || p1.getValinta().equals("paperi") && p2.getValinta().equals("kivi")
                || p1.getValinta().equals("sakset") && p2.getValinta().equals("paperi")) {
            p1.lisaaVoitto();
        } else {
            p2.lisaaVoitto();
        }
    }

    /**
     * Pelaa yksi kierros Kivi-paperi-sakset-peliä ja kasvattaa pelatut pelit laskuria.
     */
    private void pelaaKierros() {
        pelatutPelit++;

        p1.arvoValinta();
        p2.arvoValinta();
        System.out.println();

        System.out.println("Pelaaja 1: " + p1.getValinta() + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2.getValinta() + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
    }

    /**
     * Tarkistaa, onko peli ohi ja tulostaa pelin tuloksen.
     */
    private void tarkistaLoppuminen() {
        if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
            kaynnissa = false;
            System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");

            if (p1.getVoitot() > p2.getVoitot()) {
                System.out.println("Pelaaja 1 voittaa!");
            } else if (p1.getVoitot() < p2.getVoitot()) {
                System.out.println("Pelaaja 2 voittaa!");
            } else {
                System.out.println("Tasapeli!");
            }
        }
    }

    /**
     * Palauttaa listan pelaajista. Käytetään testaamiseen.
     * @return pelaajalista
     */

    public Pelaaja[] getPlayers() {
        Pelaaja[] plrs = {p1, p2};
        return plrs;
        }

    /**
     * Palauttaa tasapelien määrän. Käytetään testaamiseen.
     * @return tasapelien lukumäärä.
     */

    public int getTasapelit() {
        return tasapelit;
    }

    /**
     * Palauttaa käynnissä olemisen totuusarvon.
     * @return käynnissä bloolean.
     */

    public boolean getKaynnissa(){
        return kaynnissa;
    }
}
