package com.kps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testiluokka Peli-luokan testaamiseen.
 *
 * @author Mikko Hänninen
 */
class PeliTest {

    /**
     * Viite Peli-olioon, jota käytetään testeissä.
     */
    private Peli peli;

    /**
     * Pelaaja-taulukko, joka sisältää pelikentän molemmat pelaajat.
     */
    private Pelaaja[] plrs;

    /**
     * Alustaa peli-olion ja pelaajat ennen jokaista testiä.
     */
    @BeforeEach
    public void init() {
        peli = new Peli();
        plrs = peli.getPlayers();
    }

    /**
     * Testaa peliä varmistaen, että se loppuu oikein, kun ennalta määrätty kierrosten määrä on pelattu.
     */
    @Test
    public void peliEndTest() {
        int rounds = 3; // Määritetään ennalta määrättyjen kierrosten lukumäärä
        Peli peli = new Peli();
        peli.pelaa(); // Pelaa peliä

        // Tarkistaa, onko jommankumman pelaajan voitot saavuttaneet ennalta määrättyjen kierrosten lukumäärän
        assertTrue(peli.getPlayers()[0].getVoitot() == rounds || peli.getPlayers()[1].getVoitot() == rounds,
                "Peli ei lopu oikein");
    }

    /**
     * Parametrizoitu testi, joka tarkistaa, että pelaaja 1 voittaa oikein erilaisilla valinnoilla.
     *
     * @param str1 Pelaaja 1:n valinta
     * @param str2 Pelaaja 2:n valinta
     */
    @ParameterizedTest
    @CsvSource({"paperi, kivi", "kivi, sakset", "sakset, paperi"})
    public void p1WinsTest(String str1, String str2) {

        // Asettaa pelaajien valinnat
        plrs[0].setValinta(str1);
        plrs[1].setValinta(str2);

        peli.vertaaValinnat(); // Vertaa valintoja

        // Tarkistaa, onko pelaaja 1 voittanut ja pelaaja 2 hävinnyt
        assertTrue(plrs[0].getVoitot() == 1 && plrs[1].getVoitot() == 0,
                "P1 voittojen tarkistus ei toimi.");
    }

    /**
     * Parametrizoitu testi, joka tarkistaa, että pelaaja 2 voittaa oikein erilaisilla valinnoilla.
     *
     * @param str1 Pelaaja 1:n valinta
     * @param str2 Pelaaja 2:n valinta
     */
    @ParameterizedTest
    @CsvSource({"kivi, paperi", "sakset, kivi", "paperi, sakset"})
    public void p2WinsTest(String str1, String str2) {

        // Asettaa pelaajien valinnat
        plrs[0].setValinta(str1);
        plrs[1].setValinta(str2);

        peli.vertaaValinnat(); // Vertaa valintoja

        // Tarkistaa, onko pelaaja 2 voittanut ja pelaaja 1 hävinnyt
        assertTrue(plrs[0].getVoitot() == 0 && plrs[1].getVoitot()== 1,
                "P2 voittojen tarkistus ei toimi");
    }

    /**
     * Testaa tasapelin laskemista oikein.
     */
    @Test
    public void tasapelitTest() {

        // Asettaa molemmille pelaajille saman valinnan
        plrs[0].setValinta("testi");
        plrs[1].setValinta("testi");
        peli.vertaaValinnat(); // Vertaa valintoja

        // Tarkistaa, onko tasapeli toteutunut
        assertTrue(peli.getTasapelit() == 1 && plrs[0].getVoitot() == 0 && plrs[1].getVoitot()== 0, "Tasapelien arvionti ei toimi.");
    }

    /**
     * Testaa pelin toimintaan olennaisesti liittyvän kaynnissa-muuttujan arvot alussa ja lopussa.
     */

    @Test
    public void kaynnissaTest() {
        assertTrue(peli.getKaynnissa(), "Pelin alustus ei toimi oikein.");
        peli.pelaa();
        assertTrue(!peli.getKaynnissa(), "Peli ei päättynyt oikein.");
    }
}