package com.codecool.xdvirus.onlineShop.dao;

import com.codecool.xdvirus.onlineShop.dao.intefaces.Dao;
import com.codecool.xdvirus.onlineShop.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer> {

    @Override
    public List<Customer> readContent() throws SQLException {
        ResultSet resultSet = new Sql().selectSql("SELECT * FROM customers");
        List<Customer> customerList = new ArrayList<>();
        while(resultSet.next()){
            customerList.add(new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("order_id")));
        }
        return customerList;
    }

    @Override
    public void createContent(Customer object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("INSERT INTO customers (id, name, email, order_id) values (?,?,?,?)");
        preparedStatement.setInt(1, object.getId());
        preparedStatement.setString(2,object.getName());
        preparedStatement.setString(3,object.getEmail());
        preparedStatement.setInt(4,object.getOrder_id());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void updateContent(Customer object) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("UPDATE customers SET name = ?, email = ?, order_id = ? WHERE id = ?");
        preparedStatement.setString(1,object.getName());
        preparedStatement.setString(2,object.getEmail());
        preparedStatement.setInt(3, object.getOrder_id());
        preparedStatement.setInt(4,object.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    @Override
    public void removeContent(int id) throws SQLException {
        PreparedStatement preparedStatement = new Sql().prepareSql("DELETE FROM customers WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
