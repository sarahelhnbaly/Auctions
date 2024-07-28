package org.example;

public abstract class Person {
    public abstract void registerUsers(int n);
    public abstract void registerBid();
    public abstract int getUserId();
    public abstract String getFirstname();
    public abstract String getLastname();
    public abstract double getAmount();
    public abstract void setAmount(double amount);
}
