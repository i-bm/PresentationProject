package com.tlc.turntabl;

import static java.lang.Thread.sleep;
import static java.time.LocalTime.now;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public abstract class TemplateClass extends DBConnection {

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees" + "  (emp_id, firstname, lastname, email) VALUES " +
            " (?, ?, ?, ?);";

    private static final String SELECT_EMPLOYEE_SQL = "SELECT id, emp_id, firstname, lastname, email from employees where id = ?";


    public void save( Employee employee) throws InterruptedException, SQLException {

        this.operation1();
        this.executeInsertQuery(employee);
        this.operation2();
    }


    public final void get( Integer id) throws InterruptedException, SQLException {

        this.operation1();
        this.executeSelectQuery(id);
        this.operation2();
    }

    // abstract method1
    public abstract void operation1() throws InterruptedException;

    // abstract method2
    public abstract void operation2() throws InterruptedException;


    //template method 1
    public final void executeInsertQuery(Employee employee) throws SQLException, InterruptedException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
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

            System.out.println("Updated Rows: 1");
            System.out.println("Finish Time: " + now());
            System.out.println();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    //template method 2
    public final void executeSelectQuery(Integer id) throws SQLException, InterruptedException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_SQL)) {
            //delay execution by 2 milliseconds
            System.out.print("Executing Query");
            for(int i=0; i <= 2; i ++){
                sleep(1000);
                System.out.print(".");
            };
            System.out.println();
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int Id = rs.getInt("id");
                String empId = rs.getString("emp_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println();
                System.out.println(Id + ", " + empId +", " + firstname + ", " + lastname + ", " + email);
                System.out.println();
            }
            System.out.println("Updated Rows: 1");
            System.out.println("Finish Time: " + now());
            System.out.println();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }


}
