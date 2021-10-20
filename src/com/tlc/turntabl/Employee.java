package com.tlc.turntabl;

import static java.lang.Thread.sleep;

public class Employee extends TemplateMethod{

    private String empId;
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String empId, String firstName, String lastName, String email) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void operation1() throws InterruptedException {
        System.out.print("Operation1 in execution");
        for(int i=0; i <= 2; i ++){
            sleep(1000);
            System.out.print(".");
        };
        System.out.print("\n");
        System.out.println("Done: Operation1 ");
        System.out.print("\n");
    }

    @Override
    public void operation2() throws InterruptedException {
        System.out.print("Operation2 in execution");
        for(int i=0; i <= 2; i ++){
            sleep(1000);
            System.out.print(".");
        };
        System.out.print("\n");
        System.out.println("Done: Operation2 ");
        System.out.print("\n");
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
