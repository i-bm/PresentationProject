package com.tlc.turntabl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres", "password");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

//        User user = new User("Isaac", "Boakye-Manu","isaac.boakye-manu@turntabl.io");
//        user.save(user);
//    }
}
