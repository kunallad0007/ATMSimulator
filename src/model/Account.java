package model;

public class Account {
    private String userName, passWord;
    private double balance;

    // Define constructor
    public Account(String username, String passWord, double balance){
        this.userName = username;
        this.passWord = passWord;
        this.balance = balance;
    }

    public String getUserName(){
        return userName;
    }

    public boolean checkPassword(String inputPassword){
        return passWord.equals(inputPassword);
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

}
