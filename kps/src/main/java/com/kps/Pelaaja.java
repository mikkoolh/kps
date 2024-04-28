
package com.kps;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitot;
    private String valinta;
    private String[] vaihtoehdot = {"kivi", "paperi", "sakset"};

    /**
     * Arvo kivi, paperi tai sakset ja tallenna se 
     */

    public void arvoValinta() {
        valinta = vaihtoehdot[(int) (Math.random() * 3)];
    }

    public String getValinta() {
        return valinta;
    }

    public void lisaaVoitto() {
        voitot++;
    }

    public int getVoitot() {
        return (voitot);
    }
}
