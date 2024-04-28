
package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    int voitot;      // Voittojen lukumäärä
    int voitotYhteensä;

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    public int setVoitot() {
        int voitotYhteensä = voitot++;
        return voitotYhteensä;
    }

    public int getVoitot() {
        return (voitot);
    }
}
