package com.codecool.xdvirus.onlineShop.dao;

import java.sql.*;


public class Sql {
    Connection connection;
    PreparedStatement preparedStatement;

    public Sql() {
        connection = new Connector().connection(); //add connection to this class
        preparedStatement = null;
    }
    public PreparedStatement prepareSql(String sql) throws SQLException {
        this.preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }
    public ResultSet selectSql(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = prepareSql(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
