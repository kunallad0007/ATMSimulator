package services;
import model.Account;

public class ATMServices {
    
    // Creating instance of object variable
    private Account account;

    // Constructor injection of Account
    public ATMServices(Account account){
        this.account = account;
    }

    // Checking Login Details
    public boolean login(String userName, String passWord){
        return account.getUserName().equals(userName) && account.checkPassword(passWord);
    }

    // Checking Balance Method
    public void checkBalance(){
        System.out.println("Available Balance: ₹" + account.getBalance());
    }

    // Deposit amount
    public void depositMoney(double amount){
        if(amount > 0){
            account.deposit(amount);
            System.out.println("Deposited Amount: ₹" + amount);
        }else{
            System.out.println("Invalid deposit amount...");
        }
    }

    // Withdrawn amount
    public void withdrawnMoney(double amount){
        if(amount > 0){
            if(account.withdraw(amount)){
                System.out.println("Withdrawn Amount: ₹" + amount);
            }else{
                System.out.println("Insufficient Balance...");
            }
        }else{
            System.out.println("Invalid withdrawn amount.");
        }
    }

}
