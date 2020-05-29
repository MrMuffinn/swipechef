package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gebruiker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GebruikerMySQLDaoImpl extends MySQLBaseDao implements GebruikerDao {


    @Override
    public boolean save(Gebruiker gebruiker) {
        try (Connection conn = getConnection()) {
            String query = "INSERT INTO gebruiker (voornaam, achternaam, email, wachtwoord, rol) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gebruiker.getVoornaam(),
                    gebruiker.getAchternaam(), gebruiker.getEmail(), gebruiker.getWachtwoord(), gebruiker.getRol());
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Gebruiker findByEmail(String email) {
        String query = "SELECT * FROM gebruiker WHERE email = ?";
        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            Gebruiker gebruiker = null;
            while (resultSet.next()) {
                gebruiker = new Gebruiker(resultSet.getInt("id"),
                        resultSet.getString("voornaam"),
                        resultSet.getString("achternaam"),
                        resultSet.getString("email"),
                        resultSet.getString("wachtwoord"),
                        resultSet.getString("rol"));
            }
            closeConnection();
            return gebruiker;
        } catch (SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Gebruiker findById(int id) {
        return null;
    }

    private PreparedStatement initPrepareStatement(Connection conn, String query, Object... args) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        for (int i = 1; i < args.length; i++) {
            preparedStatement.setObject(i, args[i]);
        }
        return preparedStatement;
    }
}
