package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Basket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao implements Dao<Basket> {

    @Override
    public List<Basket> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM baskets");
        List<Basket> basketList = new ArrayList<>();
        while (resultSet.next()) {
            basketList.add(new Basket(resultSet.getInt("id"), resultSet.getInt("prod_id"),
                    resultSet.getInt("quantity_of_product"), resultSet.getInt("order_id")));
        }
        return basketList;
    }

    @Override
    public void createContent(Basket object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO baskets (id, prod_id, quantity_of_product, order_id) values(?, ?, ?, ?)");
        preparedStatement.setInt(1, object.getId());
        preparedStatement.setInt(2,object.getProduct_id());
        preparedStatement.setInt(3, object.getQuantity_of_product());
        preparedStatement.setInt(4,object.getOrder_id());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void updateContent(Basket object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE baskets SET prod_id = ? WHERE id = ?");
        preparedStatement.setInt(1,object.getProduct_id());
        preparedStatement.setInt(2, object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM baskets WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
