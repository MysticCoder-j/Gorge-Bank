import java.util.Scanner;

public class Account {
    //instance variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //method for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }

    }

    //method for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    //method showing previous transaction
    void getPreviousTransaction () {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }else{
            System.out.println("No transaction occurred");
        }
    }
        //method calculating interest of current funds after # of years
        void calculateInterest(int years) {
            double interestRate = .0196;
            double newBalance = (balance * interestRate * years) + balance;
            System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
            System.out.println("After " + years + " years, your balance will be: " + newBalance);
        }
        //method showing the menu
        void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Welcome, " + customerName + "!");
            System.out.println("Your ID is: " + customerID);
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("A. Check your balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdrawal");
            System.out.println("D. View a previous transaction");
            System.out.println("E. Calculate interest");
            System.out.println("F. Exit");

            do {
                System.out.println();
                System.out.print("Enter an option: ");
                char option1 = scanner.next().charAt(0);  //whatever they type in we take just the first character
                option = Character.toUpperCase(option1);  //makes UI case insensitive, reducing errors
                System.out.println();

                switch(option) {
                    //case 'A' allows the user to check account balance
                    case 'A':
                        System.out.println("+++++++++++++++++++++++++++++++++");
                        System.out.println("+++ Balance = $" + balance + " ++++++++++");
                        System.out.println("+++++++++++++++++++++++++++++++++");
                        System.out.println();
                        break;
                    //case 'B' allows user to deposit to account
                    case 'B':
                        System.out.print("Enter deposit amount: ");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println();
                        break;
                    //case 'C' allows user to withdraw from account
                    case 'C':
                        System.out.print("Enter withdrawal amount: ");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println();
                        break;
                    //case 'D' allows user to view most recent transaction
                    case 'D':
                        System.out.println("+++++++++++++++++++++++++++++++++");
                        getPreviousTransaction();
                        System.out.println("+++++++++++++++++++++++++++++++++");
                        System.out.println();
                        break;
                    //case 'E' calculates accrued interest
                    case 'E':
                        System.out.print("Enter the number of years of accrued interest: ");
                        int years = scanner.nextInt();
                        calculateInterest(years);
                        break;
                    //case 'F' exits user from their account
                    case 'F':
                        System.out.println("\"+++++++++++++++++++++++++++++++++\"");
                        break;
                    //default case lets user know they've entered an invalid char
                    default:
                        System.out.print("Error: invalid option. Please enter A, B, C, D, or E: ");
                        break;
                }
        } while(option != 'F');
            System.out.println("Thank you for banking with Gorge Bank!");

    }

        }
