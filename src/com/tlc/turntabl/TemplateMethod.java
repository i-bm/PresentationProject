package com.tlc.turntabl;

import java.util.List;
import static java.lang.Thread.sleep;
import static java.time.LocalTime.now;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TemplateMethod extends DBConnection {

    private static final String INSERT_USERS_SQL = "INSERT INTO employees" + "  (emp_id, firstname, lastname, email) VALUES " +
            " (?, ?, ?, ?);";

    public void save( Employee employee) throws InterruptedException, SQLException {

        this.operation1();
//        this.createQuery(user);// INSERT INTO `Users`(firstname, lastname) values('Isaac','Boakye');
        this.executeInsertQuery(employee);

        this.operation2();
    }


    public final void createQuery(Employee employee) throws InterruptedException {
        System.out.println(employee.toString());
        System.out.print("Executing Query");
        for(int i=0; i <= 4; i ++){
            sleep(5000);
            System.out.print(".");
        };
        System.out.println();
        System.out.println("Updated Rows: 1");
        System.out.println("Finish Time: " + now());
    }


    public void executeInsertQuery(Employee employee) throws SQLException, InterruptedException {
//        System.out.println(INSERT_USERS_SQL);

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //delay execution by 2 milliseconds
            System.out.print("Executing Query");
            for(int i=0; i <= 2; i ++){
                sleep(1000);
                System.out.print(".");
            };
            System.out.println();
            preparedStatement.setString(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

//            System.out.println();
            System.out.println("Updated Rows: 1");
            System.out.println("Finish Time: " + now());
            System.out.println();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }



    public abstract void operation1();
    public abstract void operation2();
}
