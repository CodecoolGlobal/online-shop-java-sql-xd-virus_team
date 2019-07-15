package com.codecool.xdvirus.onlineShop.dao;

import java.sql.*;


public class Sql {
    private Connector connector;
    PreparedStatement preparedStatement;

    public Sql() {
        connector = new Connector(); //add connection to this class
        preparedStatement = null;
    }
    public void disconnectSql(){
        connector.disconnection();
    }
    public PreparedStatement prepareSql(String sql) throws SQLException {
        this.preparedStatement = connector.connection().prepareStatement(sql);
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
