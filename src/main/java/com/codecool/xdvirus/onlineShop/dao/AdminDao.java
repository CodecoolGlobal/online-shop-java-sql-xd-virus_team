package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements Dao<Admin> {
    Sql sql;

    @Override
    public List<Admin> readContent() {
        List<Admin> categoryList = new ArrayList<>();
        sql = new Sql();
        try {
            ResultSet resultSet = sql.selectSql("SELECT * FROM admin");
            while (resultSet.next()) {
                categoryList.add(new Admin(resultSet.getInt("id_admin"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return categoryList;
    }

    @Override
    public void createContent(Admin object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("INSERT INTO admin (id_admin, name) " +
                    "values(?, ?)");
            preparedStatement.setInt(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContent(Admin object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE admin " +
                    "SET name = ? " +
                    "WHERE id_admin = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContent(int id) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM admin " +
                    "WHERE id_admin = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
