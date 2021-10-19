package com.tlc.turntabl;

import java.sql.SQLException;
import java.util.Random;
import java.lang.String;


public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

       Random rand = new Random();
       String empId =  "ERNO 201909" + String.valueOf(rand.nextInt(100));


        Employee employee1 = new Employee(empId, "Isaac","Boakye-Manu", "isaac.boakye-manu@turntabl.io");
        employee1.save(employee1);


//        User user2 = new User("Dawud", "Mohammed", "dawud.mohammed@turntabl.io");
//        user2.save(user2);

//        User user3 = new User("Ofoe", " Fiergbor", "ofoe.fiergbor@turntabl.io");
//        user3.save(user3);
    }
}
