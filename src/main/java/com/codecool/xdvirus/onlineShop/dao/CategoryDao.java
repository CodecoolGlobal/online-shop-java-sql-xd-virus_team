package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.model.Category;
import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements Dao<Category> {
    Sql sql;

    @Override
    public List<Category> readContent() {
        List<Category> categoryList = new ArrayList<>();
        sql = new Sql();
        try {
            ResultSet resultSet = sql.selectSql("SELECT * FROM category");
            while (resultSet.next()) {
                categoryList.add(new Category(resultSet.getInt("id_category"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return categoryList;
    }

    @Override
    public void createContent(Category object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("INSERT INTO category (name) values (?)");
            //preparedStatement.setInt(1, object.getId());
            preparedStatement.setString(1, object.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContent(Category object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE category SET name = ? WHERE id_category = ?");
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
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM category WHERE id_category = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
