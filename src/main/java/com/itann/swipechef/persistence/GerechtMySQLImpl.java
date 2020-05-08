package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GerechtMySQLImpl extends MySQLBaseDao implements GerechtDao {

    @Override
    public boolean save(Gerecht gerecht) {
        try(Connection conn = getConnection()) {
            String query = "INSERT INTO gerechten (bereidingstijd, bereidingswijze, energiePP, naam) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht.getBereidingstijd(),
                    gerecht.getBereidingswijze(), gerecht.getEnergiePP(), gerecht.getNaam());
        }
        catch(SQLException e) {
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Gerecht> findAll() {
        return null;
    }

    @Override
    public Gerecht findById(Gerecht gerecht) {
        String query = "SELECT * FROM gerechten WHERE id = ?";
        try(Connection conn = getConnection()){
            PreparedStatement preparedStatement = initPrepareStatement(conn, query, gerecht.getId());
        }
        catch(SQLException e){
            System.out.println("Could not create a connection");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Gerecht gerecht) {
        return false;
    }

    @Override
    public boolean delete(Gerecht gerecht) {
        return false;
    }

    private PreparedStatement initPrepareStatement(Connection conn, String query, Object ...args) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        for(int i=1; i < args.length; i++){
            preparedStatement.setObject(i, args[i]);
        }
        return preparedStatement;
    }
}
