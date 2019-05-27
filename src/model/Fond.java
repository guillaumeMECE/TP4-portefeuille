/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author helen
 */
public class Fond {
    //attribut 
    protected double amount;

    //constructor
    public Fond() {
        amount = 0.0;
    }

    public Fond(double _amount) {
        this.amount = _amount;
    }

    //Getters and setters
    public void setAmount(double newAmount) {
        amount = newAmount;
    }

    public double getAmount() {
        return amount;
    }
}
