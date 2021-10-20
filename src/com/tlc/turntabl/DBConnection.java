package com.tlc.turntabl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Thread.sleep;


public class DBConnection {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/turntabl";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "password";

//    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
//            " (?, ?, ?);";

//    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//    private static final String SELECT_ALL_USERS = "select * from users";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println();
            //delay execution by 2milliseconds
            System.out.print("Connecting to Database");
            for(int i=0; i <= 3; i ++){
                sleep(1000);
                System.out.print(".");
            };
            System.out.println();
            System.out.println("Database Connected Successfully!");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch ( Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    protected void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

