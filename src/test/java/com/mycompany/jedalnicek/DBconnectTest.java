package com.mycompany.jedalnicek;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class DBconnectTest {
    
    public DBconnectTest() {
    }
    
    @Ignore
    @Test
    public void getIdReceptuTest() throws SQLException{
       DBconnect instance = new DBconnect();
       String nazov = "segedinsky gulas";
       int vysledok = 0;
       vysledok = instance.getIdReceptu(nazov);
       assertEquals(2, vysledok);
   }
    
   @Ignore
   @Test
   public void testGetIdSuroviny() throws SQLException{
       DBconnect instance = new DBconnect();
       String nazov = "cesnak";
        int vysledok = 0;
       vysledok = instance.getIdSuroviny(nazov);
       assertEquals(4, vysledok);
   }
   
    
}
