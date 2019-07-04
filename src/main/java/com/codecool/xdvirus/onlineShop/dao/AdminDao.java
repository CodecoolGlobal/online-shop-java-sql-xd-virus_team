package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements Dao<Admin> {
    @Override
    public List<Admin> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM admins");
        List<Admin> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            categoryList.add(new Admin(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return categoryList;
    }

    @Override
    public void createContent(Admin object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO admins (id, name) values(?, ?)");
        preparedStatement.setInt(1, object.getId());
        preparedStatement.setString(2,object.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void updateContent(Admin object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE admins SET name = ? WHERE id = ?");
        preparedStatement.setString(1,object.getName());
        preparedStatement.setInt(2, object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM admins WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
