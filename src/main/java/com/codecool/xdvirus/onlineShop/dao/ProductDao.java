package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {


    @Override
    public List<Product> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM products");
        List<Product> productList = new ArrayList<>();
        while(resultSet.next()){
            productList.add(new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("amount"),
                    resultSet.getBoolean("availibility"),
                    resultSet.getInt("category")));
        }
        return productList;
    }

    @Override
    public void createContent(Product object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO products (id, name, price, amount, isAvailable, category) values (?,?,?,?,?,?)");
        preparedStatement.setInt(1,object.getId());
        preparedStatement.setString(2,object.getName());
        preparedStatement.setDouble(3,object.getPrice());
        preparedStatement.setInt(4,object.getAmount());
        preparedStatement.setBoolean(5,object.isAvailable());
        preparedStatement.setInt(6,object.getCategory());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void updateContent(Product object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE products SET name = ?, price = ?, amount = ?, isAvailable = ?, category = ? WHERE id = ?");
        preparedStatement.setString(1,object.getName());
        preparedStatement.setDouble(2,object.getPrice());
        preparedStatement.setInt(3,object.getAmount());
        preparedStatement.setBoolean(4,object.isAvailable());
        preparedStatement.setInt(5,object.getCategory());
        preparedStatement.setInt(6,object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM products WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
