package com.mycompany.jedalnicek;

public class Surovina {
    String nazov;
    float Bielkoviny;
    float sacharidy;
    float tuky;

    public Surovina(String nazov, float Bielkoviny, float sacharidy, float tuky) {
        this.nazov = nazov;
        this.Bielkoviny = Bielkoviny;
        this.sacharidy = sacharidy;
        this.tuky = tuky;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public float getBielkoviny() {
        return Bielkoviny;
    }

    public void setBielkoviny(float Bielkoviny) {
        this.Bielkoviny = Bielkoviny;
    }

    public float getSacharidy() {
        return sacharidy;
    }

    public void setSacharidy(float sacharidy) {
        this.sacharidy = sacharidy;
    }

    public float getTuky() {
        return tuky;
    }

    public void setTuky(float tuky) {
        this.tuky = tuky;
    }
    
    
}
