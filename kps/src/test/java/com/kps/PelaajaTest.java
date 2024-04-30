package com.kps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testiluokka Pelaaja-luokan testaamiseen.
 *
 * @author Mikko Hänninen
 */
class PelaajaTest {

    /**
     * Viite Pelaaja-olioon, jota käytetään testeissä.
     */
    private Pelaaja p1;

    /**
     * Alustaa p1-olion ennen jokaista testiä.
     */
    @BeforeEach
    public void init() {
        p1 = new Pelaaja();
    }

    /**
     * Testaa arvoValinta-metodia varmistaen, että se palauttaa validin valinnan ("kivi", "paperi" tai "sakset").
     */
    @Test
    public void arvoValintaTest() {
        String result;

        p1.arvoValinta();

        result = p1.getValinta();
        assertTrue(result.equals("kivi") || result.equals("paperi") || result.equals("sakset"),
                "Tuloksen oltava kivi, paperi tai sakset");
    }

    /**
     * Testaa arvoValinta-metodia varmistaen, että se tuottaa erilaisia valintoja useilla peräkkäisillä kutsuilla.
     */
    @Test
    public void getDifferentAnswersTest() {
        String result;
        String differentResult;
        boolean different = false;

        p1.arvoValinta();

        result = p1.getValinta();

        for(int i = 0; i < 10; i++){
            p1.arvoValinta();
            differentResult = p1.getValinta();
            if (!differentResult.equals(result)){
                different = true;
                i = 10;
            }
        }
        assertTrue(different == true, "Tuloksen täytyy vaihdella, eli paluuarvon oltava totta.");
    }

    /**
     * Testaa lisaaVoittoja-metodia varmistaen, että se lisää voittojen määrää oikein.
     */
    @Test
    public void lisaaVoittojaTest() {
        int start = p1.getVoitot();
        p1.lisaaVoitto();

        int end = p1.getVoitot();
        assertTrue(start == 0 && end == 1,
                "Voittaja ei lisätty");
    }

    /**
     * Testaa getVaihtoehdot-metodia varmistaen, että se palauttaa 3 vaihtoehtoa.
     */
    @Test
    public void getVaihtoehdotTest() {

        assertTrue(p1.getVaihtoehdot().length == 3,
                "Voittaja ei lisätty");
    }
}
