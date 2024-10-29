package com.poteapp.calculator;

import java.util.Stack;

public class Calculator {

    private final StringBuilder currentInput = new StringBuilder();
    private final Stack<String> expression = new Stack<>();

    public void append(String value) {
        currentInput.append(value);
    }

    public void clear() {
        currentInput.setLength(0);
        expression.clear();
    }

    public String getCurrentInput() {
        return currentInput.toString();
    }

    public void addOperator(String operator) {
        if (currentInput.length() > 0) {
            expression.push(currentInput.toString());
            currentInput.setLength(0);
        }
        expression.push(operator);
    }

    public String calculate() {
        if (currentInput.length() > 0) {
            expression.push(currentInput.toString());
        }
        // Simple evaluation logic (you might want to use a more robust solution)
        double result = 0;
        String operator = "";
        while (!expression.isEmpty()) {
            String token = expression.remove(0);
            if (isOperator(token)) {
                operator = token;
            } else {
                double value = Double.parseDouble(token);
                switch (operator) {
                    case "+":
                        result += value;
                        break;
                    case "-":
                        result -= value;
                        break;
                    case "*":
                        result *= value;
                        break;
                    case "÷":
                        result /= value;
                        break;
                    default:
                        result = value;
                        break;
                }
            }
        }
        currentInput.setLength(0);
        currentInput.append(result);
        return currentInput.toString();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("÷");
    }
}