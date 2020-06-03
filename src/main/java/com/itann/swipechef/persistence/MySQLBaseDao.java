//package com.itann.swipechef.persistence;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MySQLBaseDao implements BaseDao {
//
//    private Connection conn;
//
//    @Override
//    public Connection getConnection() {
//        try {
//            // Verbinding maken met de DB
//            DriverManager.getConnection("jdbc:mysql://localhost:8080/swipechef?serverTimezone=EST&useSSL=false&allowPublicKeyRetrieval=true", "root", "!morrisNik9");
//        }
//        // Als het verbinden fout gaat
//        catch (SQLException e) {
//            System.out.println("Could not create a connection");
//            e.printStackTrace();
//        }
//        return this.conn;
//    }
//
//    @Override
//    public void closeConnection() {
//        try {
//            conn.close();
//        }
//        catch (SQLException e) {
//            System.out.println("Could not create a connection");
//            e.printStackTrace();
//        }
//    }
//}
