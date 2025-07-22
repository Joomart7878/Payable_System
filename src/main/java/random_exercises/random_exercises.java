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


    // Exercise 8 Basic Generics
    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {return first;}
        public U getSecond() {return second;}
        public void setFirst(T first) {this.first = first;}
        public void setSecond(U secondt) {this.second = second;}

        @Override
        public String toString() {
            return String.format("Pair{first=%s, second=%s", first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    // Exercise 9 ArrayList and Enhanced For Loop
    public static List<String> filterStrings(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str != null && str.length() > 3 && Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }
        return result;
    }

    // Exercise 10 HashMap Operations
    public static Character findMostFrequentCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequency.merge(c, 1, Integer::sum);
        }

        return frequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Exercise 11 Generic Methods and Wildcards
    public static double sumNumbers(List<? extends Number> numbers) {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    // Exercise 12 Functional Interfaces and Lambda Expressions
    @FunctionalInterface
    interface MathOperation{
        int calculate(int a, int b);
    }

    public static int applyOperation(int a, int b, MathOperation operation) {
        return operation.calculate(a, b);
    }

    public static void demonstrateLambdas() {
        MathOperation addition = Integer::sum;
        MathOperation multiplication = (x, y) -> x * y;
        MathOperation substraction = (x, y) -> x - y;

        System.out.println("Addition: " + applyOperation(5, 3, addition));
        System.out.println("Maltiplication: " + applyOperation(5, 3, multiplication));
        System.out.println("Substracton: " + applyOperation(5, 3, substraction));

    }

    // Exercise 13 Stream API - Basic Operation
    public static List<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    // Exercise 14 Stream API - Advanced with Collectors
    static class Person {
        private final String name;
        private final int age;
        private final String city;

        public Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() {return name;}
        public int getAge() {return age;}
        public String getCity() {return city;}

        @Override
        public String toString() {
            return String.format("Person{name='%s, age=%d, city=%s'}", name, age, city);
        }

        public static Map<String, Double> calculateAverageAgeByCity(List<Person> people) {
            return people.stream()
                    .collect(Collectors.groupingBy(
                            Person::getCity,
                            Collectors.averagingInt(Person::getAge)
                    ));
        }
    }

    // Exercise 15 Custom Comparator and Collections.sort()
        record Student(String name, double grade, int age) {

        @Override
            public String toString() {
                return String.format("Student{name='%s, grade=%.1f, age=%d}", name, grade, age);
            }
        }

    public static void sortStudents(List<Student> students) {
        students.sort(
                Comparator.comparingDouble(Student::grade).reversed()
                        .thenComparingInt(Student::age)
        );
    }

    // Exercise 16 Exception Handling and Custom Exceptions
    static class InsufficientFundsExceptions extends Exception{
        public InsufficientFundsExceptions(String message) {
            super(message);
        }
    }

    static class BankAccountExceptions extends BankAccount {
        public BankAccountExceptions(String accountNumber, String ownerName, double balance){
            super(accountNumber, ownerName, balance);

        }
        public void withdrawWithException(double amount) throws InsufficientFundsExceptions {
            if (amount > getBalance()) {
                throw new InsufficientFundsExceptions(
                        String.format("Insufficient funds. Requested: %.2f, Avaialable: %.2f",
                                amount, getBalance())
                );
            }
            withdraw(amount);
        }
    }

    public static List<Double> processWithdrawals(BankAccountExceptions account, List<Double> amounts) {
        List<Double> successful = new ArrayList<>();
        for (double amount : amounts) {
            try {
                account.withdrawWithException(amount);
                successful.add(amount);
            } catch (InsufficientFundsExceptions e) {
                System.out.println("Failed withdrawal: " + e.getMessage());
            }
        }
        return successful;

    }

    public record Product(long id, String name, String category) {
        public Object price() {
            return null;
        }
    }



    }




