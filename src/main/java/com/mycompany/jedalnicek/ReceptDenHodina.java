package com.mycompany.jedalnicek;

/**
 *
 * @author John
 */

public class ReceptDenHodina {
    private String nazov;
    private int den;
    private int hodina;

    public ReceptDenHodina(String nazov, int den, int hodina) {
        this.nazov = nazov;
        this.den = den;
        this.hodina = hodina;
    }

    public String getNazov() {
        return nazov;
    }

    public int getDen() {
        return den;
    }

    public int getHodina() {
        return hodina;
    }

    @Override
    public String toString() {
        return nazov+" den:"+den+" hodina:"+hodina;
    }
    
    
}
