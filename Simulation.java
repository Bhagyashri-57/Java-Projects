import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulation {

    // Note: Non-Static methods or variables cannot be accessed inside static methods!
    // Note: Vise Versa is possible!

    // Difference between List and Array:
    /*

        List :- Stores collection of data, It is dynamic (no fixed sized), faster to access, rich in mothod,
        Array :- Stores collection of data but it is not dynamic (fixed sized)

     */

        // Interface : blue print to create class
        // class : blue print to create objects
        // object: instance of a class
    

    static Scanner sc = new Scanner(System.in);
    static List<Bank> accounts = new ArrayList<>();


    public static long generateAccountNumber(){
        Random r = new Random();
        return r.nextLong(1248248298l)+9999999999l;
    }

    public static void openAccountSimulation(){
        String master;
        int pin;
        double balance;
        System.out.println("Fill in the followin form!");
        System.out.print("Enter your name: ");
        master = sc.next();
        System.out.println("Set 4-digit PIN: ");
        pin = sc.nextInt();
        System.out.println("Deposit an initial amount (₹500): ");
        balance = sc.nextDouble();

        long accNumber = generateAccountNumber();
        
        // Here now we can create our account!
        Bank acc = new Bank(accNumber, pin, master, balance);
        accounts.add(acc);
        System.out.println("Congratulations🎉!\n Bank Account Created Successfully!");
        acc.display();
    }

    private static int isValidAccountNumber(long accNum){
        int i = 0;
        for(Bank acc : accounts){
            if(acc.getAccNumber() == accNum){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void existingAccountSimulation(){
        long accNum;
        System.out.println("Enter your account number: ");
        accNum = sc.nextLong();
        int index = isValidAccountNumber(accNum);
        if(index != -1){
            System.out.println("Welcome "+accounts.get(index).getMaster()+"!");
            System.out.println("Select from the below operations: ");
            System.out.println("1. Credit ");
            System.out.println("2. Debit ");
            System.out.println("3. Display details");
            System.out.println("4. Exit");
            System.out.print(": ");
            int choice = sc.nextInt();
            double amount = 0.0;
            switch(choice){
                case 1:
                    System.out.print("Enter the amount to credit: ");
                    amount = sc.nextDouble();
                    accounts.get(index).credit(amount);
                    break;
                case 2:
                    System.out.print("Enter the amount to debit: ");
                    amount = sc.nextDouble();
                    System.out.println("Enter pin: ");
                    int pin = sc.nextInt();
                    accounts.get(index).debit(amount, pin);
                    break;
                case 3:
                    accounts.get(index).display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        } else{
            System.out.println("Invalid Account Number!");
        }

    }


    public static void main(String[] args) {

        while(true){
            System.out.println("\n=========Welcome To Bhagya's Bank=========");
            System.out.println("Select from the below operations:");
            System.out.println("1. Open an Account\n"); // SignUP
            System.out.println("2. Select an Existing Account\n"); // SignIN
            System.out.println("3. Exit");
            System.out.print(": ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    openAccountSimulation();
                    break;
                case 2:
                    existingAccountSimulation();
                    break;
                case 3:
                    System.out.println("Thanks for visiitng Bhagya's Bank🙏\n");
                    System.exit(0); // 0: Normal exit , 1: Abnormal exit
                default:
                    System.out.println("Invalid Option! Please try again!\n");
            }
        }

    }
    
}