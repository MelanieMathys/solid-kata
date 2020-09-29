package com.codurance.ocp;

public class Employee {

    private int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    public int payAmount() {
        return salary;
    }
}
