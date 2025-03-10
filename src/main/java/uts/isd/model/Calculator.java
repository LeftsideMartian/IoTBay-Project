package uts.isd.model;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    //Raise a to the power of b
    public double power(int a, int b) {
        return Math.pow(a, b);
    }

    // Evaluate an expression in the format: a+b+c+d
    public int evaluate(String expression) {
        int sum = 0;

        for (String summand : expression.split("\\+")) {
            sum += Integer.valueOf(summand);
        }

        return sum;
    }
}
