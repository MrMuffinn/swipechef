package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class IngredientMySQLDaoImpl extends MySQLBaseDao implements IngredientDao{


    @Override
    public boolean save(Ingredient ingredient) {

        try(Connection conn = getConnection()) {
            String query = "INSERT INTO ingredient (gerecht, product, hoeveelheidPP) VALUES (?,?,?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, ingredient.getGerecht(),
                    ingredient.getProduct(), ingredient.getHoeveelheidPP());
            return preparedStatement.execute();
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Ingredient> findAll() {
        String query = "SELECT * FROM ingredient";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            List<Ingredient> ingredienten = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ingredienten.add(new Ingredient(resultSet.getInt("id"), resultSet.getString("gerecht"),
                        resultSet.getString("product"), resultSet.getInt("hoeveelheidPP")));
            }
            return ingredienten;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Ingredient findById(int id) {
        String query = "SELECT * FROM ingredient WHERE id = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Ingredient ingredient = null;
            while(resultSet.next()){
                ingredient = new Ingredient(resultSet.getInt("id"), resultSet.getString("gerecht"),
                        resultSet.getString("product"), resultSet.getInt("hoeveelheidPP"));
            }
            closeConnection();
            return ingredient  ;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
           }

        return null;
    }

    @Override
    public boolean update(Ingredient ingredient) {
        String query = "UPDATE ingredient SET gerecht = ?, product = ? hoeveelheidPP =?";
        try( Connection conn = getConnection()){
        PreparedStatement preparedStatement = initPrepareStatement(conn, query, ingredient.getGerecht(), ingredient.getProduct(), ingredient.getHoeveelheidPP());
            return preparedStatement.execute();

        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Ingredient ingredient) {
        String query = "DELETE FROM ingredient where id = ?";
        try( Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, ingredient.getId());
            return preparedStatement.execute();

        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }



        return false;
    }

    @Override
    public List<Ingredient> findByGerecht(Gerecht gerecht) {
        String query = "SELECT * FROM ingredient WHERE gerecht = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht);
            List<Ingredient> ingredienten = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ingredienten.add(new Ingredient(resultSet.getInt("id"), resultSet.getString("gerecht"),
                        resultSet.getString("product"), resultSet.getInt("hoeveelheidPP")));
            }
            return ingredienten;
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
