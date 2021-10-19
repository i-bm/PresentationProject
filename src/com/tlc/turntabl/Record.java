package com.tlc.turntabl;

import java.util.List;
import static java.lang.Thread.sleep;
import static java.time.LocalTime.now;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Record extends DBConnection {

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (firstname, lastname, email) VALUES " +
            " (?, ?, ?);";

    public void save( User user) throws InterruptedException, SQLException {

        // this.validate();
//        this.beforeSave();
//        this.connectDB();

//        this.createQuery(user);// INSERT INTO `Users`(firstname, lastname) values('Isaac','Boakye');
        this.executeInsertQuery(user);
        this.afterSave();
    }

    public final void connectDB(){
        System.out.println("Connecting to Database....!");
        System.out.println("Connection Successful!");

    }


    public final void createQuery(User user) throws InterruptedException {
        System.out.println(user.toString());
        System.out.print("Executing Query");
        for(int i=0; i <= 4; i ++){
            sleep(5000);
            System.out.print(".");
        };
        System.out.println();
        System.out.println("Updated Rows: 1");
        System.out.println("Finish Time: " + now());
    }


    public void executeInsertQuery(User user) throws SQLException{
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getLastName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    // public abstract void connectDB();
//public abstract void validate();
    public abstract void beforeSave();
    public abstract void afterSave();
}
