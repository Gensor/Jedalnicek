package com.mycompany.jedalnicek;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


public class DBconnect {
    private String host = "localhost";
    private String port = "3306";
    private String user = "root";
    private String pass = "";
    private String database = "mydb";
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    public DBconnect() {
        try{
            connection = getConnection();
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+host+":"+port+"/"+database;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(connectionString,user,pass);
        
        return connection;
    }
    
    public void vlozRecept(String nazovReceptu) throws SQLException{
        String insert = "INSERT INTO mydb.recepty (Nazov) VALUES (?)";
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, nazovReceptu);
        preparedStatement.executeUpdate();
    }

    public String getReceptDenHodina(int den,int hodina) throws SQLException {
        String select = "select r.nazov as recept from den_has_recepty dr\n" 
            +"join den d on dr.Den_idDen=d.idDen\n" 
            +"join recepty r on dr.Recepty_idRecepty=r.idRecepty\n" 
            +"where dr.Den_idDen = ? and dr.hodina = ?";
        
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, den);
        preparedStatement.setInt(2, hodina);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()){
            String recept_rs = resultset.getString("recept");
            return recept_rs;
        }
        
        return null;
    }

    public int getBielkovinyNaDen(int den) throws SQLException {
        String select = "select SUM(s.bielkoviny*(sr.hmotnostSuroviny*0.01)) as bielkoviny from den_has_recepty dr\n" 
            +"join recepty r on r.idRecepty=dr.Recepty_idRecepty\n" 
            +"join suroviny_na_recept sr on sr.Recepty_idRecepty=r.idRecepty\n" 
            +"join suroviny s on s.idSuroviny=sr.Suroviny_idSuroviny\n" 
            +"where Den_idDen = ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, den);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()){
            int bielkoviny = resultset.getInt("bielkoviny");
            return bielkoviny;
        }
        
        return 0;
    }
    
    public int getSacharidyNaDen(int den) throws SQLException {
        String select = "select SUM(s.sacharidy*(sr.hmotnostSuroviny*0.01)) as sacharidy from den_has_recepty dr\n" 
            +"join recepty r on r.idRecepty=dr.Recepty_idRecepty\n" 
            +"join suroviny_na_recept sr on sr.Recepty_idRecepty=r.idRecepty\n" 
            +"join suroviny s on s.idSuroviny=sr.Suroviny_idSuroviny\n" 
            +"where Den_idDen = ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, den);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()){
            int sacharidy = resultset.getInt("sacharidy");
            return sacharidy;
        }
        
        return 0;
    }
    
    public int getTukyNaDen(int den) throws SQLException {
        String select = "select SUM(s.tuky*(sr.hmotnostSuroviny*0.01)) as tuky from den_has_recepty dr\n" 
            +"join recepty r on r.idRecepty=dr.Recepty_idRecepty\n" 
            +"join suroviny_na_recept sr on sr.Recepty_idRecepty=r.idRecepty\n" 
            +"join suroviny s on s.idSuroviny=sr.Suroviny_idSuroviny\n" 
            +"where Den_idDen = ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, den);
        ResultSet resultset = preparedStatement.executeQuery();
        
        while(resultset.next()){
            int tuky = resultset.getInt("tuky");                                
            return tuky;
        }
        
        return 0;
    }

    public void vymazReceptZDenHasRecept(int hodina, int den) throws SQLException {
        String delete = "DELETE FROM mydb.den_has_recepty WHERE Den_idDen = ? AND den_has_recepty.hodina = ?";
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, den);
        preparedStatement.setInt(2, hodina);
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getRecepty() throws SQLException {
        String select = "select nazov from recepty";
        preparedStatement = connection.prepareStatement(select);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<String> recepty = new ArrayList<String>();
        
        while(rs.next()){
            String nazov = rs.getString("nazov");
            recepty.add(nazov);
        }
        
        return recepty;
    }

    public void vlozReceptDenHasRecepty(String recept, int den, int hodina) throws SQLException {
       String insert = "INSERT INTO mydb.den_has_recepty (Den_idDen, Recepty_idRecepty, hodina) "
                       + "VALUES (?, (select idRecepty from recepty where recepty.nazov like ?), ?)";
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, den);
        preparedStatement.setString(2, recept);
        preparedStatement.setInt(3, hodina);
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getSuroviny() throws SQLException {
        ArrayList<String> suroviny = new ArrayList<>();
        String select = "select nazov from suroviny";
        preparedStatement = connection.prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
            String nazovSuroviny = resultSet.getString("nazov");
            suroviny.add(nazovSuroviny);
        }
        
        
        return suroviny;
    }
    
   

    public void vlozSurovinyNaRecept(Recept recept) throws SQLException {
        int idReceptu = getIdReceptu(recept.getNazovReceptu());
        HashMap<String,Integer> list = recept.getSurovinyMap();
        
        for (String nazovSuroviny : list.keySet()) {
            int idSuroviny = getIdSuroviny(nazovSuroviny);
            int hmotnost = list.get(nazovSuroviny);
            vlozJednuSurovinuNaRecept(idReceptu,idSuroviny,hmotnost);
        }
    }
    
    public int getIdReceptu(String nazov) throws SQLException {
        String select = "select idRecepty from recepty where nazov like ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1, nazov);
        ResultSet rs = preparedStatement.executeQuery();
        
        int id = -1;
        
        while(rs.next()){
           id=rs.getInt("idRecepty");
           return id;
        }
        
        return id;
    }

    public int getIdSuroviny(String nazovSuroviny) throws SQLException {
        String select = "select idSuroviny from suroviny where nazov like ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1, nazovSuroviny);
        ResultSet rs = preparedStatement.executeQuery();
        
        int id = -1;
        
        while(rs.next()){
           id=rs.getInt("idSuroviny");
           return id;
        }
        
        return id;
    }

    private void vlozJednuSurovinuNaRecept(int idReceptu, int idSuroviny, int hmotnost) throws SQLException {
        String insert = "INSERT INTO mydb.suroviny_na_recept "
                + "(Recepty_idRecepty, Suroviny_idSuroviny, hmotnostSuroviny)"
                + " VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, idReceptu);
        preparedStatement.setInt(2, idSuroviny);
        preparedStatement.setInt(3, hmotnost);
        preparedStatement.executeUpdate();
    }

    public boolean hasRecept(String nazov) throws SQLException {
        String select = "select COUNT(*) as pocet from recepty where nazov like ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1, nazov);
        ResultSet resultSet = preparedStatement.executeQuery();
        int pocet = 0 ;
        while(resultSet.next()){
           pocet=resultSet.getInt("pocet");
           return pocet>0;
        }
        
        return false;
    }

    public void vymazRecept(String recept) throws SQLException {
        if(!hasRecept(recept)){
            return;
        }
        vymazReceptDenHasRecepty(recept);
        vymazReceptSurovinyNaRecept(recept);
        vymazReceptRecepty(recept);
    }

    private void vymazReceptDenHasRecepty(String recept) throws SQLException {
        String delete = "delete from den_has_recepty where Recepty_idRecepty = ?";
        int idRecept = getIdReceptu(recept);
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, idRecept);
        preparedStatement.executeUpdate();
    }

    private void vymazReceptSurovinyNaRecept(String nazovReceptu) throws SQLException {
        String delete = "delete from suroviny_na_recept where Recepty_idRecepty = ?";
        int idRecept = getIdReceptu(nazovReceptu);
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, idRecept);
        preparedStatement.executeUpdate();
    }

    private void vymazReceptRecepty(String recept) throws SQLException {
        String delete = "delete from recepty where idRecepty = ?";
        int idRecept = getIdReceptu(recept);
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, idRecept);
        preparedStatement.executeUpdate();
    }

    public void vlozSurovinu(String nazov, float bielkoviny, float sacharidy, float tuky) throws SQLException {
        String insert = "INSERT INTO mydb.suroviny (nazov, bielkoviny, sacharidy, tuky)"
                + " VALUES (?, ?, ?, ?)"; 
        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, nazov);
        preparedStatement.setFloat(2, bielkoviny);
        preparedStatement.setFloat(3, sacharidy);
        preparedStatement.setFloat(4, tuky);
        preparedStatement.executeUpdate();
    }

    public boolean hasSurovina(String nazov) throws SQLException {
        String select = "select count(*) as pocet from suroviny where nazov like ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setString(1, nazov);
        ResultSet resultSet = preparedStatement.executeQuery();
        int pocet = 0 ;
        while(resultSet.next()){
           pocet=resultSet.getInt("pocet");
           return pocet>0;
        }
        
        return false;
    }

    public void setSurovina(String nazov, float bielkoviny, float sacharidy, float tuky) throws SQLException {
        int idSuroviny = getIdSuroviny(nazov);
        String update="UPDATE mydb.suroviny t "
                + "SET t.bielkoviny = ?, t.sacharidy = ?, t.tuky = ? "
                + "WHERE t.idSuroviny = ?";
        preparedStatement = connection.prepareStatement(update);
        preparedStatement.setFloat(1, bielkoviny);
        preparedStatement.setFloat(2, sacharidy);
        preparedStatement.setFloat(3, tuky);
        preparedStatement.setInt(4,idSuroviny);
        preparedStatement.executeUpdate();
    }

    public Surovina getSurovina(String nazov) throws SQLException {
        int idSuroviny = getIdSuroviny(nazov);
        String select = "SELECT t.* FROM mydb.suroviny t where idSuroviny = ?";
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, idSuroviny);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
           Float bielkoviny=resultSet.getFloat("bielkoviny");
           Float sacharidy = resultSet.getFloat("sacharidy");
           Float tuky = resultSet.getFloat("tuky");
           return new Surovina(nazov, bielkoviny, sacharidy, tuky);
        }
        
        return null;
    }

    public void vymazSurovinu(String nazovSuroviny) throws SQLException {
        if(!hasSurovina(nazovSuroviny)){
            return;
        }
        int idSuroviny = getIdSuroviny(nazovSuroviny);
        String delete ="DELETE FROM mydb.suroviny WHERE idSuroviny = ?";
        preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, idSuroviny);
        preparedStatement.executeUpdate();
    }

    public HashMap<String, Integer> getSurovinyReceptu(String nazovReceptu) throws SQLException {
        HashMap<String, Integer> list = new HashMap<>();
        int idReceptu = getIdReceptu(nazovReceptu);
        String select = "SELECT s.nazov as nazov, t.hmotnostSuroviny as hmotnost "
                + "FROM mydb.suroviny_na_recept t "
                + "join suroviny s on s.idSuroviny=t.Suroviny_idSuroviny "
                + "where t.Recepty_idRecepty = ?" ;
        preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, idReceptu);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
           String surovina =resultSet.getString("nazov");
           int hmotnost = resultSet.getInt("hmotnost");
           list.put(surovina, hmotnost);
        }
        
        return list;
    }

    public void upravSurovinyNaRecept(Recept recept) throws SQLException {
        vymazReceptSurovinyNaRecept(recept.getNazovReceptu());
        vlozSurovinyNaRecept(recept);
    }

    public void upravRecept(String nazov,String novyNazov) throws SQLException {
        int idReceptu = getIdReceptu(nazov);
        String update = "UPDATE mydb.recepty t SET t.nazov = ? WHERE t.idRecepty = ?";
        preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, novyNazov);
        preparedStatement.setInt(2, idReceptu);
        preparedStatement.executeUpdate();
    }
    
    
}
