package com.kps;

/**
 *
 * @author Ira Dook
 */
public class Peli {
        private Pelaaja p1 = new Pelaaja();
        private Pelaaja p2 = new Pelaaja();
        private boolean kaynnissa = true;
        private int pelatutPelit = 0;
        private int tasapelit = 0;
       
        public void pelaa() {
            while(kaynnissa) {
                tulostaTilanne();

                pelaaKierros();

                vertaaValinnat();             

                tarkistaLoppuminen();
            }
        }

        private void tulostaTilanne() {
            System.out.printf("\nErä: %d ================\n", pelatutPelit + 1);
            System.out.printf("Tasapelien lukumäärä: %d\n", tasapelit);
        }

        private void vertaaValinnat() {
    
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

        private void pelaaKierros() {
            pelatutPelit++;

            p1.arvoValinta();
            p2.arvoValinta();
            System.out.println();

            System.out.println("Pelaaja 1: " + p1.getValinta() + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            System.out.println("Pelaaja 2: " + p2.getValinta() + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
        }

        private void tarkistaLoppuminen() {
            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                kaynnissa = false;
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
            }
        }
}
