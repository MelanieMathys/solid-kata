package com.codurance.ocp;

public class ManagerEmployee extends Employee
{
    private int bonus;

    ManagerEmployee(int salary, int bonus) {
        super(salary);
        this.bonus = bonus;
    }

    @Override
    public int payAmount() {
        return super.payAmount() + bonus;
    }
}
