import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount{
    public static int totalAmount = 0;
    public static void withdraw(int amount){
        if(totalAmount==0){
            System.out.println("Insufficient Balance! Your account balance is empty.\n");
            return;
        }
        else if(amount > totalAmount){
            System.out.println("You have not enough amount...\nTry again later...");
            return;
        }
        totalAmount = totalAmount - amount;
        System.out.println("Withdraw Successfully!!\n");
    }

    public static void deposite(int amount){
        if(amount < 0){
            System.out.println("Negative amount not Accepted, Try again later...\n");
        }
        totalAmount += amount;
        System.out.println("Deposite Successfully!!\n");
    }

    public static void checkBalance(){
        System.out.println("Balance = " +totalAmount+"\n");
    }
}

public class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount obj = new BankAccount();

        for(int i = 1; i > 0; i++){
            System.out.println("Press 1 for Withdraw\nPress 2 for Deposite\nPress 3 for Check Balance\nPress 4 for Exit.\n");
            System.out.print("Enter no. - ");
            int n = sc.nextInt();

            if(n == 1){
                System.out.print("Enter amount = ");
                try {
                    int amt = sc.nextInt();
                    obj.withdraw(amt);
                }
                catch (InputMismatchException e) {
                    System.out.println("Decimal type amount not withdraw by ATM\nTry again later...\n");
                    break;
                }
                continue;
            }
            else if(n == 2){
                System.out.print("Enter amount = ");
                try{
                    int amt = sc.nextInt();
                    obj.deposite(amt);
                }
                catch (InputMismatchException e) {
                    System.out.println("Decimal type amount not deposite in the ATM\nTry again later...\n");
                    break;
                }
                continue;
            }
            else if(n == 3){
                obj.checkBalance();
                continue;
            }

            else if(n == 4){
                System.out.println("Exited!");
                break;
            }

            else{
                System.out.println("Invalid Input! Try Again...\n");
                continue;
            }
            
        }
    }
}