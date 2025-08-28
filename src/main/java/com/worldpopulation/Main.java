package com.worldpopulation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //Connection
    //Statement(insert data directly) /PreparedStatement(More secure)
    //ResultSet (result the data in tables just like in database)(start the table row from index 1)

    private Connection getConnection(String ipaddress, int portno, String dbname, String username, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ipaddress + ":" + portno + "/" + dbname, username, password);
            System.out.println("Connected to database successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Connection con =  m.getConnection("localhost", 3306,"world_population","root","");

    }
}