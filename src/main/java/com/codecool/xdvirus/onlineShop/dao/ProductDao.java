package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {
    Sql sql;

    @Override
    public List<Product> readContent() {
        List<Product> productList = new ArrayList<>();
        sql = new Sql();
        try {
            ResultSet resultSet = sql.selectSql("SELECT * FROM product");
            while (resultSet.next()) {
                productList.add(new Product(
                        resultSet.getInt("id_product"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"),
                        resultSet.getBoolean("availibility"),
                        resultSet.getInt("category")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return productList;
    }

    @Override
    public void createContent(Product object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("INSERT INTO product (id_product, " +
                    "name, price, amount, isAvailable, category) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setDouble(3, object.getPrice());
            preparedStatement.setInt(4, object.getAmount());
            preparedStatement.setBoolean(5, object.isAvailable());
            preparedStatement.setInt(6, object.getCategory());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateContent(Product object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE product SET name = ?, " +
                    "price = ?, " +
                    "amount = ?, " +
                    "isAvailable = ?, " +
                    "category = ? " +
                    "WHERE id_product = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setDouble(2, object.getPrice());
            preparedStatement.setInt(3, object.getAmount());
            preparedStatement.setBoolean(4, object.isAvailable());
            preparedStatement.setInt(5, object.getCategory());
            preparedStatement.setInt(6, object.getId());
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
            PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM product " +
                    "WHERE id_product, = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
