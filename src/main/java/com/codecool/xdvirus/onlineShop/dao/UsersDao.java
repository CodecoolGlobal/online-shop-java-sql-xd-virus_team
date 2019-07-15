package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements Dao<User> {
    Sql sql;

    @Override
    public List<User> readContent() {
        sql = new Sql();
        List<User> categoryList = new ArrayList<>();
        try {
            ResultSet resultSet = sql.selectSql("SELECT * FROM user");
            while (resultSet.next()) {
                categoryList.add(new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("permission")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return categoryList;
    }

    @Override
    public void createContent(User object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("INSERT INTO user " +
                    "(id_user, login, password, permission) " +
                    "values(?, ?, ?, ?)");
            preparedStatement.setInt(1, object.getId());
            preparedStatement.setString(2, object.getLogin());
            preparedStatement.setString(3, object.getPassword());
            preparedStatement.setInt(4, object.getPermission());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContent(User object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE user " +
                    "SET login = ?, password = ?, permission = ? " +
                    "WHERE id_user = ?");
            preparedStatement.setString(1, object.getLogin());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setInt(3, object.getPermission());
            preparedStatement.setInt(4, object.getId());
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
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM user WHERE id_user = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
