package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerechtMySQLDaoImpl extends MySQLBaseDao implements GerechtDao {

    @Override
    public boolean save(Gerecht gerecht) {
        try(Connection conn = getConnection()) {
            String query = "INSERT INTO gerecht (bereidingstijd, bereidingswijze, energiePP, naam) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht.getBereidingstijd(),
                    gerecht.getBereidingswijze(), gerecht.getEnergiePP(), gerecht.getNaam());
            return preparedStatement.execute();
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Gerecht> findAll() {
        String query = "SELECT * FROM gerecht";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            List<Gerecht> gerechten = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                gerechten.add(new Gerecht(resultSet.getInt("id"), resultSet.getInt("bereidingstijd"),
                        resultSet.getString("bereidingswijze"), resultSet.getInt("energiePP"),
                        resultSet.getString("naam")));
            }
            return gerechten;
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Gerecht findById(int id) {
        String query = "SELECT * FROM gerecht WHERE id = ?";
        try(Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Gerecht gerecht = null;
            while(resultSet.next()) {
                gerecht = new Gerecht(resultSet.getInt("id"), resultSet.getInt("bereidingstijd"),
                        resultSet.getString("bereidingswijze"),
                        resultSet.getInt("energiePP"),
                        resultSet.getString("naam"));
            }
            closeConnection();
            return gerecht;
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Gerecht gerecht) {
        String query = "UPDATE gerecht SET bereidingstijd = ?, bereidingswijze = ?, energiePP = ?, naam = ?";
        try (Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht.getBereidingstijd(),
                    gerecht.getBereidingswijze(), gerecht.getEnergiePP(), gerecht.getNaam());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Gerecht gerecht) {
        String query = "DELETE FROM ? WHERE id = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht.getId());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
            return false;
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
