package random_exercises;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class random_exercises {

    // Exercise 1 Operations
    public static String calculateOperations(int a, int b) {
        int sum = a + b;
        int difference = a - b;
        int product = a * b;

        return String.format("Sum: %d, Difference: %d, Product: %d", sum, difference, product);
    }

    // Exercise 2 Leap Year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Exercise 3 Reverse String
    public static String reverseString(String input) {
        if (input == null) return null;
        char[] chars = input.toCharArray();
        for (int i=0; i<=chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }

    // Exercise 4 Array Processing
    public static Integer findSecondLargest(int[] array) {
        if (array == null || array.length < 2) return null;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? null : secondLargest;
    }

    // Exercise 5 Basic Class and Encapsulation
    public static class BankAccount {
        private String accountNumber;
        private double balance;
        private String ownerName;

        public BankAccount(String accountNumber, String ownerNumber, double balance) {
        }

        public void BankAccount(String accountNumber, String ownerName, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.ownerName = ownerName;
        }

        public BankAccount(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getAccountNumber() {return accountNumber;}
        public double getBalance() {return balance;}
        public String getOwnerName() {return ownerName;}

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public void deposit(double amount) {
            if (amount > 0){
                balance += amount;
            }
        }
        public void withdraw (double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }
        @Override
        public String toString() {
            return String.format("Account{$s, Owner: $s, Balance: %.2f", accountNumber, ownerName, balance);
        }
    }

    // Exercise 6 Constructor Overloading and this keyword
    static class BankAccountExtended extends BankAccount {
        public BankAccountExtended() {
            this("DEFAULT-001", "Unknown", 0.0);
        }

        public BankAccountExtended(String ownerName) {
            this(generateAccountNumber(), ownerName, 0.0);
        }

        public BankAccountExtended(String ownerName, double balance) {
            this(generateAccountNumber(), ownerName, balance);
        }

        public BankAccountExtended(String accountNumber, String ownerNumber, double balance) {
            super(accountNumber, ownerNumber, balance);
        }

        private static String generateAccountNumber() {
            return "ACC-" + System.currentTimeMillis() % 100000;
        }
    }

    // Exercise 7 Inheritance and Method Overriding
    static class SavingAccount extends BankAccount {
        private double interestRate;

        public SavingAccount(String accountNumber, String ownerName, double balance, double interestRate) {
            super(accountNumber, ownerName, balance);
            this.interestRate = interestRate;
        }

        public double getInterestRate() {return interestRate;}
        public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

        public double calculateMonthlyInterest() {
            return getBalance() * (interestRate / 12 / 100);
        }

        public void applyInterest() {
            double interest = calculateMonthlyInterest();
            deposit(interest);
        }

        @Override
        public String toString() {
            return super.toString() + String.format(", Interest Rate: %2f%%", interestRate);
        }
    }





    }




