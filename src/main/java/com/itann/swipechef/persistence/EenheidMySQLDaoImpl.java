package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Eenheid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EenheidMySQLDaoImpl extends MySQLBaseDao implements EenheidDao {


    @Override
    public boolean save(Eenheid eenheid) {
        try(Connection conn = getConnection()) {
            String query = "INSERT INTO eenheid (naam) VALUES (?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, eenheid.getNaam());
            return preparedStatement.execute();
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Eenheid> findAll() {
        String query = "SELECT * FROM eenheid";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            List<Eenheid> eenheden = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                eenheden.add(new Eenheid(resultSet.getString("naam")));
            }
            return eenheden;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Eenheid eenheid) {
        String query = "UPDATE eenheid SET naam = ?";
        try( Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, eenheid.getNaam());
            return preparedStatement.execute();

        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Eenheid eenheid) {
        String query = "DELETE FROM eenheid where naam = ?";
        try( Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, eenheid.getNaam());
            return preparedStatement.execute();

        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }



        return false;
    }

    @Override
    public Eenheid findByName(String naam) {
        String query = "SELECT * FROM eenheid WHERE naam = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, naam);
            ResultSet resultSet = preparedStatement.executeQuery();
            Eenheid eenheid = null;
            while(resultSet.next()){
                eenheid = new Eenheid(resultSet.getString("naam"));
            }
            closeConnection();
            return eenheid  ;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return null;
    }

    private PreparedStatement initPrepareStatement(Connection conn, String query, Object ...args) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        for(int i=1; i < args.length; i++){
            preparedStatement.setObject(i, args[i]);
        }
        return preparedStatement;
    }
}
