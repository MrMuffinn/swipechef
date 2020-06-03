//package com.itann.swipechef.persistence;
//
//import com.itann.swipechef.domain.Gebruiker;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class GebruikerMySQLRepositoryImpl extends MySQLBaseDao implements GebruikerRepository {
//
//
//
//
//    @Override
//    public boolean save(Gebruiker gebruiker) {
//        try (Connection conn = getConnection()) {
//            String query = "INSERT INTO gebruiker (voornaam, achternaam, email, wachtwoord, rol) VALUES (?,?,?,?,?)";
//            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gebruiker.getVoornaam(),
//                    gebruiker.getAchternaam(), gebruiker.getEmail(), gebruiker.getWachtwoord(), gebruiker.getRol());
//            return preparedStatement.execute();
//        } catch (SQLException e) {
//            System.out.println("Could not create a connection");
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//
//
//    @Override
//    public Gebruiker findById(int id) {
//        return null;
//    }
//
//    private PreparedStatement initPrepareStatement(Connection conn, String query, Object... args) throws SQLException {
//        PreparedStatement preparedStatement = conn.prepareStatement(query);
//        for (int i = 1; i < args.length; i++) {
//            preparedStatement.setObject(i, args[i]);
//        }
//        return preparedStatement;
//    }
//}
