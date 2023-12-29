package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Connection conn= DriverManager.getConnection("jdbc:sqlite:src/main/resources/sqlite.db");
            Statement stmt=conn.createStatement();
            String url="select name,hint from demo";
            String url1="select name,hint from demo where id=3";
            ResultSet rezultat=stmt.executeQuery(url1);
            PreparedStatement s=conn.prepareStatement("update demo set name='Amina' where id=2");
            /*PreparedStatement dodajRedStatement=conn.prepareStatement("insert into demo(id,name,hint) values(?,?,?)");
            dodajRedStatement.setInt(1,33);
            dodajRedStatement.setString(2,"Muhidin");
            dodajRedStatement.setString(3,"AAAAA lud");
            dodajRedStatement.executeUpdate();*/
            s.executeUpdate();
            while(rezultat.next())
            {
                String ime=rezultat.getString(1);
                String hint=rezultat.getString(2);
                System.out.println(ime+" "+hint);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
