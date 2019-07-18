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
                        resultSet.getInt("order_id")));
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
                    "( prod_id, quantity_of_product, order_id) values( ?, ?, ?)");
            //preparedStatement.setInt(1, object.getId());
            preparedStatement.setInt(1, object.getProduct_id());
            preparedStatement.setInt(2, object.getQuantity_of_product());
            preparedStatement.setInt(3, object.getOrder_id());
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
            PreparedStatement preparedStatement = sql.prepareSql("UPDATE basket SET prod_id = ?0" +
                    " WHERE id_basket = ?");
            preparedStatement.setInt(1, object.getProduct_id());
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
            PreparedStatement preparedStatement = sql.prepareSql("DELETE FROM basket WHERE id_basket = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            sql.disconnectSql();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
