
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
        
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            return;
        }
        if (kasvatuskoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            lisaaLukuKohtaan(luku, alkioidenLkm);
            return true;
        }
        if (!kuuluu(luku)) {
            lisaaLuku(luku);
            return true;
        }
        return false;
    }

    private void lisaaLuku(int luku) {
        lisaaLukuKohtaan(luku, alkioidenLkm);
        if (alkioidenLkm == ljono.length) {
            kasvataTaulukkoa();
        }
    }
    
    private void kasvataTaulukkoa() {
        int[] vanhaSisalto = new int[alkioidenLkm];
        kopioiTaulukko(ljono, vanhaSisalto, ljono.length);
        ljono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(vanhaSisalto, ljono, vanhaSisalto.length);
    }
    
    private void lisaaLukuKohtaan(int luku, int kohta) {
        ljono[kohta] = luku;
        alkioidenLkm++;
    }

    public boolean kuuluu(int luku) {
        return lukuIndeksissa(luku) != -1;
    }
    
    private int lukuIndeksissa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int kohta = lukuIndeksissa(luku);
        if (kohta != -1) {
            ljono[kohta] = 0;
            siirraLukujaKohtiTaulukonAlkua(kohta);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void siirraLukujaKohtiTaulukonAlkua(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = ljono[j];
            ljono[j] = ljono[j + 1];
            ljono[j + 1] = apu;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi, int pituus) {
        System.arraycopy(vanha, 0, uusi, 0, pituus);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            case 1:
                return "{" + ljono[0] + "}";
            default:
                return taulukkoMerkkijonoksi();
        }
    }

    private String taulukkoMerkkijonoksi() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += ljono[i];
            tuotos += ", ";
        }
        tuotos += ljono[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        kopioiTaulukko(ljono, taulu, taulu.length);
        return taulu;
    }  

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return JoukkoOperaatio.yhdiste(a, b);
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return JoukkoOperaatio.leikkaus(a, b);
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        return JoukkoOperaatio.erotus(a, b);
    }  
}