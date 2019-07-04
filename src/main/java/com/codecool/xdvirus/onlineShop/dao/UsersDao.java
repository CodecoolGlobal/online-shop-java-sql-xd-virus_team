package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements Dao<User> {

    @Override
    public List<User> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM users");
        List<User> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            categoryList.add(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getInt("permission")));
        }
        return categoryList;
    }

    @Override
    public void createContent(User object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO users " +
                "(id, login, password, permission) " +
                "values(?, ?, ?, ?)");
        preparedStatement.setInt(1, object.getId());
        preparedStatement.setString(2,object.getLogin());
        preparedStatement.setString(3,object.getPassword());
        preparedStatement.setInt(4,object.getPermission());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void updateContent(User object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE users " +
                "SET login = ?, password = ?, permission = ? " +
                "WHERE id = ?");
        preparedStatement.setString(1,object.getLogin());
        preparedStatement.setString(2,object.getPassword());
        preparedStatement.setInt(3,object.getPermission());
        preparedStatement.setInt(4, object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM users WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
