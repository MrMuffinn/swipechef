package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMySQLDaoImpl extends MySQLBaseDao implements ProductDao {


    @Override
    public boolean save(Product product) {
        try(Connection conn = getConnection()) {
            String query = "INSERT INTO product (naam, eenheid, energiePE) VALUES (?,?,?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, product.getNaam(),
                    product.getEenheid(), product.getEnergiePE());
            return preparedStatement.execute();
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Product> findAll() {
        String query = "SELECT * FROM product";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            List<Product> products = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt("id"), resultSet.getString("naam"),
                        resultSet.getString("eenheid"), resultSet.getInt("energiePE")));
            }
            return products;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findById(int id) {
        String query = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while(resultSet.next()){
                product = new Product(resultSet.getInt("id"), resultSet.getString("naam"),
                        resultSet.getString("eenheid"), resultSet.getInt("energiePE"));
            }
            closeConnection();
            return product  ;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Product product) {
        String query = "UPDATE product SET naam = ?, eenheid = ?, energiePE = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, product.getNaam(), product.getEenheid(), product.getEnergiePE());
            return preparedStatement.execute();
        }
        catch(SQLException e) {
                System.out.println("Could not create a connection");
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        String query = "DELETE FROM product where id = ?";
        try( Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, product.getId());
            return preparedStatement.execute();

        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }



        return false;
    }

    @Override
    public List<Product> findByIngredient(Ingredient ingredient) {
        String query = "SELECT * FROM product WHERE ingredient = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, ingredient);
            List<Product> products = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt("id"), resultSet.getString("naam"),
                        resultSet.getString("eenheid"), resultSet.getInt("energiePE")));
            }
            return products;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return null;
        }

    }

    private PreparedStatement initPrepareStatement(Connection conn, String query, Object ...args) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        for(int i=1; i < args.length; i++){
            preparedStatement.setObject(i, args[i]);
        }
        return preparedStatement;
    }
}
