/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jedalnicek;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author John
 */
public class DBconnectTest {
    
    public DBconnectTest() {
    }

    
   
   
    @Test
    public void testGetIdReceptu() throws SQLException{
        DBconnect instance = new DBconnect();
        String nazov = "segedinsky gulas";
        int vysledok = 0;
        vysledok = instance.getIdReceptu(nazov);
        assertEquals(2, vysledok);
    }
    
    @Test
    public void testGetIdSuroviny() throws SQLException{
        DBconnect instance = new DBconnect();
        String nazov = "cesnak";
        int vysledok = 0;
        vysledok = instance.getIdSuroviny(nazov);
        assertEquals(4, vysledok);
    }
    
}
