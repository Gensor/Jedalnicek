package com.mycompany.jedalnicek;

import java.util.HashMap;


public class Recept {
    private String nazovReceptu = "";
    HashMap<String,Integer> suroviny ;
    
    public Recept() {
        this.suroviny = new HashMap<String,Integer>();
    }
    
    public void pridajSurovinu(String nazov,int hmotnost){
        if( (!nazov.isEmpty()) && (hmotnost>0) ){
            suroviny.put(nazov, hmotnost);
        }
    }
    
    public void vymazSurovinu(String nazov){
        if(!nazov.isEmpty()){
            suroviny.remove(nazov);
        }
    }

    public String getNazovReceptu() {
        return nazovReceptu;
    }

    public void setNazovReceptu(String nazovReceptu) {
        this.nazovReceptu = nazovReceptu;
    }

    public void setSuroviny(HashMap<String, Integer> suroviny) {
        this.suroviny = suroviny;
    }
    
    
    
    public String[][] getSuroviny() {

        String [][] list = new String[suroviny.keySet().size()][2] ;
        int i =0;
        for (String nazov : suroviny.keySet()) {
            list[i][0]=nazov;
            list[i][1]=String.valueOf(suroviny.get(nazov));
            i++;
        }
        
        return list;
    }
    
    public HashMap<String,Integer> getSurovinyMap(){
        return suroviny;
    }
  

    
}
