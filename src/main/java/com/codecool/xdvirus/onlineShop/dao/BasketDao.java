package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Basket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao implements Dao<Basket> {
    Sql sql;

    @Override
    public List<Basket> readContent() {
        List<Basket> basketList = new ArrayList<>();
        sql = new Sql();
        try {
            ResultSet resultSet = sql.selectSql("SELECT * FROM basket");
            while (resultSet.next()) {
                basketList.add(new Basket(
                        resultSet.getInt("id_basket"),
                        resultSet.getInt("prod_id"),
                        resultSet.getInt("quantity_of_product"),
                        resultSet.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return basketList;
    }

    @Override
    public void createContent(Basket object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("INSERT INTO basket " +
                    "( prod_id, quantity_of_product) values( ?, ?)");
            preparedStatement.setInt(1, object.getProduct_id());
            preparedStatement.setInt(2, object.getQuantity_of_product());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContent(Basket object) {
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE basket SET prod_id = ?,status = ? WHERE id_basket = ?");
            preparedStatement.setInt(1, object.getProduct_id());
            preparedStatement.setString(2, object.getStatus());
            preparedStatement.setInt(3, object.getId());
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
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM basket WHERE id_basket = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeByProductId(int prod_id){

        sql = new Sql();

        try {
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM basket WHERE prod_id = ?");
            preparedStatement.setInt(1, prod_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Basket getById(int productId) {

        Basket basket  = null;
        sql = new Sql();
        try {
            PreparedStatement preparedStatement = sql.prepareSql("SELECT * FROM basket WHERE prod_id = ?");
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                basket = new Basket(
                        resultSet.getInt("id_basket"),
                        resultSet.getInt("prod_id"),
                        resultSet.getInt("quantity_of_product"),
                        resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.disconnectSql();
        return basket;
    }

}
