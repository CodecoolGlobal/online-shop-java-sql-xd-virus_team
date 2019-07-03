package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.model.Category;
import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements Dao<Category> {


    @Override
    public List<Category> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM categories");
        List<Category> categoryList = new ArrayList<>();
        while (resultSet.next()) {
            categoryList.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return categoryList;
    }

    @Override
    public void createContent(Category object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO categories (id, name) values(?, ?)");
        preparedStatement.setInt(1, object.getId());
        preparedStatement.setString(2,object.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void updateContent(Category object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE categories SET name = ? WHERE id = ?");
        preparedStatement.setString(1,object.getName());
        preparedStatement.setInt(2, object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM categories WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
