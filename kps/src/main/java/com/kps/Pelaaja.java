package com.kps;

/**
 * Luokka Pelaaja edustaa pelaajia Kivi-paperi-sakset-pelissä.
 *
 * @author Ira Dook
 */
public class Pelaaja {

    /**
     * Pelaajan voittojen lukumäärä.
     */
    private int voitot;

    /**
     * Pelaajan valitsema vaihtoehto (kivi, paperi tai sakset).
     */
    private String valinta;

    /**
     * Taulukko, joka sisältää pelin vaihtoehdot.
     */
    private String[] vaihtoehdot = {"kivi", "paperi", "sakset"};

    /**
     * Arpoo satunnaisesti uuden valinnan ja asettaa sen pelaajan valinnaksi.
     */
    public void arvoValinta() {
        valinta = vaihtoehdot[(int) (Math.random() * 3)];
    }

    /**
     * Palauttaa pelaajan valitseman vaihtoehdon.
     *
     * @return Pelaajan valitsema vaihtoehto (kivi, paperi tai sakset).
     */
    public String getValinta() {
        return valinta;
    }

    /**
     * Lisää pelaajan voittojen lukumäärää yhdellä.
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen yhteenlasketun lukumäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return (voitot);
    }

    /**
     * Palauttaa pelin vaihtoehdot taulukkona.
     *
     * @return Taulukko, joka sisältää pelin vaihtoehdot.
     */
    public String[] getVaihtoehdot() {
        return vaihtoehdot;
    }

    /**
     * Asettaa valinnan jupiter testiä varten. Ei käytetä pelissä.
     *
     */

    public void setValinta(String str) {
        valinta = str;
    }
}

