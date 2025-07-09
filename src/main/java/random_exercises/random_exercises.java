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




    }




