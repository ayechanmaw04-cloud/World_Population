package com.worldpopulation;

import java.sql.*;
import java.util.ArrayList;

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

    protected ArrayList<Country> read_DB(Connection con) {
        ArrayList<Country> countryList = new ArrayList<>();
        try {
            PreparedStatement stat = con.prepareStatement("SELECT country_name, capital_name, region_name," +
                    " sub_region_name FROM population");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                countryList.add(new Country(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stat.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return countryList;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Connection con =  m.getConnection("localhost", 3306,"world_population","root","");
        ArrayList<Country> countryList = m.read_DB(con);
        System.out.println(countryList.getLast());

        try {
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}