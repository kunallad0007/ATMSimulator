package ui;

import model.Account;
import services.ATMServices;
import java.util.Scanner;

public class ATMInterface {

    Scanner input = new Scanner(System.in);
    private ATMServices atmServices;
    
    public void startATM(){
        System.out.println("===== Welcome to the ATM Machine =====");

        //Manual DataBase Authentication
        Account account = new Account("kunal345", "kunal123", 10000);

        System.out.print("Enter UserName: ");
        String userName = input.nextLine();
        System.out.print("Enter Password: ");
        String passWord = input.nextLine();

        atmServices = new ATMServices(account);

        if(atmServices.login(userName, passWord)){
            System.out.println("✅ Login Successfull!\n");

            int choice;
            do{
                System.out.println("\n------ Menu ------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.println("Enter the choice: ");

                choice = input.nextInt();
                
                switch (choice) {
                    case 1:
                        atmServices.checkBalance();
                        break;
                    
                    case 2:
                        System.out.print("Enter the amount to deposit: ₹");
                        double depositMoney = input.nextDouble();
                        atmServices.depositMoney(depositMoney);
                        break;

                    case 3:
                        System.out.print("Enter the amount to withdraw: ₹");
                        double withdrawMoney = input.nextDouble();
                        account.withdraw(withdrawMoney);

                    case 4:
                        System.out.println("Thank You for using the ATM!");
                        break;
                
                    default:
                        System.out.println("Invalid Option Selected... Try Again");
                        break;
                }


            }while(choice != 4);

        }else{

            System.out.println("✅ Login Failed!\n");

        }

    }

}
