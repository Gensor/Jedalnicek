/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jedalnicek;

import java.sql.Connection;
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
    public void testGetReceptDenHodina() throws Exception {
        int den = 1;
        int hodina = 15;
        DBconnect instance = new DBconnect();
        ReceptDenHodina result = instance.getReceptDenHodina(den, hodina);
        
        assertNotEquals(null, result);
    }
    
}
