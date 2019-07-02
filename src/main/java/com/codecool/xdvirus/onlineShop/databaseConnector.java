package com.codecool.xdvirus.onlineShop;


import java.sql.*;

public class databaseConnector {
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/OnlineShop");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("surname");
                String  address = rs.getString("email");
                float salary = rs.getFloat("login");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "SURNAME = " + age );
                System.out.println( "EMAIL = " + address );
                System.out.println( "LOGIN = " + salary );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();





        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
