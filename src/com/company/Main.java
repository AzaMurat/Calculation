package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String operation = scanner.nextLine();
            checkForException(operation);
            String num1 = "", num2 = "";
            char operator;
            operator = operator(operation);
            num1 = number1(num1, operation);
            num2 = number2(num2, operation);
            String res = arabOrRoman(num1, num2);
            displayInfo(num1, num2, operator, res);
            sum(res, num1, num2, operator);
            System.out.println();
        }
    }

    public static void checkForException(String operation) {
        try {
            if (!operation.contains("+") &&
                    !operation.contains("-") &&
                    !operation.contains("*") &&
                    !operation.contains("/")) {
                throw new MyExeption();
            }
        } catch (MyExeption e) {
            System.out.println("Математикалык опперация эмес");
            System.exit(0);
        }
        String num1 = "", num2 = "";

        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' ||
                    operation.charAt(i) == '*' || operation.charAt(i) == '/') {

                char operator = operation.charAt(i);
                int operatorsIndex = operation.indexOf(operator);
                num1 = (operation.substring(0, operatorsIndex));
                num2 = (operation.substring(operatorsIndex + 1));
            }
        }
        try {
            boolean valid1 = num1.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
            boolean valid2 = num2.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
            if (valid1 && valid2) {
            } else {
                try {
                    int number1 = Integer.parseInt(num1);
                    int number2 = Integer.parseInt(num2);
                } catch (NumberFormatException e) {
                    System.out.println("Формат туура келбейт");
                    System.exit(0);
                }
            }
        } catch (MyExeption e) {
            System.out.println("Операция туура эмес жасалды");
            System.exit(0);
        }
    }

    public static String number1(String num1, String operation) {
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' ||
                    operation.charAt(i) == '*' || operation.charAt(i) == '/') {

                char operator = operation.charAt(i);
                int operatorsIndex = operation.indexOf(operator);
                num1 = (operation.substring(0, operatorsIndex));
            }
        }
        return num1;
    }

    public static String number2(String num2, String operation) {
        char operator = 'a';
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' ||
                    operation.charAt(i) == '*' || operation.charAt(i) == '/') {

                operator = operation.charAt(i);
                int operatorsIndex = operation.indexOf(operator);
                num2 = (operation.substring(operatorsIndex + 1));
            }
        }
        return num2;
    }

    public static char operator(String operation) {
        String num1 = "", num2 = "";
        char operator = 0;
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-' || operation.charAt(i) == '*' || operation.charAt(i) == '/') {
                operator = operation.charAt(i);
                int operatorsIndex = operation.indexOf(operator);
                num1 = (operation.substring(0, operatorsIndex));
                num2 = (operation.substring(operatorsIndex + 1));
            }
        }
        try {
            if (num2.equals("0") && operator == '/') {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ae) {
            System.out.println("Арифметикалык ката");
            System.exit(0);
        }

        return operator;
    }

    public static String integerToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public static int arabMath(int a, int b, char c) {
        int sum = 0;
        switch (c) {
            case '+':
                sum = a + b;
                break;
            case '-':
                sum = a - b;
                break;
            case '*':
                sum = a * b;
                break;
            case '/':
                sum = a / b;
                break;
        }
        return sum;
    }

    public static int romanToInteger(String roman) {
        Map<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('I', 1);
        numbersMap.put('V', 5);
        numbersMap.put('X', 10);
        numbersMap.put('L', 50);
        numbersMap.put('C', 100);
        numbersMap.put('D', 500);
        numbersMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);


            if (i > 0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i - 1))) {
                result += numbersMap.get(ch) - 2 * numbersMap.get(roman.charAt(i - 1));
            }


            else
                result += numbersMap.get(ch);
        }

        return result;
    }

    public static String arabOrRoman(String num1, String num2) {
        String arabOrRoman = "";
        boolean valid1 = num1.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        boolean valid2 = num2.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        if (valid1 && valid2) {
            arabOrRoman = "Roman";
        } else {

            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            arabOrRoman = "Arab";
        }
        return arabOrRoman;
    }

    public static void displayInfo(String num1, String num2, char operator, String res) {
        System.out.print(num1 + " + " + num2 + " = ");
    }

    public static void sum(String res, String num1, String num2, char operator) {
        if (res.equals("Roman")) {
            System.out.print(integerToRoman(arabMath(romanToInteger(num1), romanToInteger(num2), operator)));
        } else if (res.equals("Arab")) {
            System.out.println(arabMath(Integer.parseInt(num1), Integer.parseInt(num2), operator));
        }
    }
}
