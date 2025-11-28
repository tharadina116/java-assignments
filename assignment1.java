//1
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient Balance!");
        } else if(amount <= 0) {
            System.out.println("Invalid Amount!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " Withdrawn Successfully!");
        }
    }

    // Balance Check
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        Account acc = new Account("12345", "Ravi Kumar", 5000);

        acc.checkBalance();
        acc.deposit(2000);
        acc.withdraw(3000);
        acc.checkBalance();
    }
}
//2
import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Addition = " + (10 + 5));
                    break;
                case 2:
                    System.out.println("Subtraction = " + (10 - 5));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while(choice != 3);
    }
}
//3
public class Calculator {

    // 1. Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // 2. Add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // 3. Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
public class TestCalc {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));
        System.out.println(c.add(5.5, 10.2));
        System.out.println(c.add(1, 2, 3));
    }
}
//4
package com.company;

public class Employee {
    public String name;          // accessible everywhere
    protected double salary;     // accessible in subclass (even in another package)
    private int id;              // accessible only in Employee class
    String department;           // default → same package only

    public void display() {
        System.out.println("Name: " + name);
    }
}
package com.management;

import com.company.Employee;  // import required

public class Manager extends Employee {

    public void showDetails() {
        System.out.println(name);        // allowed (public)
        System.out.println(salary);      // allowed (protected)
        // System.out.println(id);       // NOT allowed (private)
        // System.out.println(department); // NOT allowed (default)
    }
}
//5
public interface Payment {
    void pay(double amount);
}
public class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}
public class PayPal implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}
public class Cash implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash.");
    }
}
//6
public class Vehicle {
    String brand;
    int speed;

    public void display() {
        System.out.println("Brand: " + brand);
    }
}
public class Car extends Vehicle {
    int doors;
}
public class Bike extends Vehicle {
    boolean hasGear;
}
