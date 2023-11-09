package calculator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solver implements ISolver {

    @Override
    public int getPrecedence(char character) {
        if (character == '+' || character == '-') {
            return  1;
        } else if (character == '*' || character == '/') {
            return 2;
        } else return -1;
    }

    @Override
    public String infixToRpn(String expression) throws SyntaxErrorException {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        expression = expression.trim().replaceAll(" +", "");
        expression = expression.replace("(-", "(0-");
        expression = expression.replace("(+", "(0+");
        if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
            expression = "0" + expression;
        }

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isLetterOrDigit(currentChar) || currentChar == '.') {
                result.append(currentChar);
                continue;
            } else {
                result.append(" ");
            }

            if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                    result.append(" ");
                }
                try {
                    stack.pop();
                } catch (EmptyStackException e) {
                    throw new SyntaxErrorException("Unbalanced parentheses!");
                }
            } else {
                while (!stack.isEmpty() && getPrecedence(currentChar) <= getPrecedence(stack.peek())) {
                    result.append(stack.pop());
                    result.append(" ");
                }
                stack.push(currentChar);
            }
        }
        result.append(" ");

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new SyntaxErrorException("Unbalanced parentheses!");
            }
            result.append(stack.pop());
            result.append(" ");
        }

        return result.toString().trim().replaceAll(" +", " ");
    }

    @Override
    public String evaluate(String expression) throws SyntaxErrorException {
        Double a, b;
        String res;
        Stack<Double> stack = new Stack<>();

        try {
            for (String token : expression.split(" ")) {
                switch (token) {
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "-" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b - a);
                    }
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    case "/" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b / a);
                    }
                    default -> stack.push(Double.parseDouble(token));
                }
            }

            res = stack.pop().toString();

        } catch (EmptyStackException e) {
            throw new SyntaxErrorException("Syntax Error!");
        } catch (NumberFormatException e) {
            throw new SyntaxErrorException("Bad Number Format!");
        }

        if (res.endsWith(".0")) {
            return res.substring(0, res.length() -  2);
        } else {
            return res;
        }
    }

    @Override
    public String solve(String expression) {
        try {
            return evaluate(infixToRpn(expression));
        } catch (SyntaxErrorException e) {
            return e.toString();
        }
    }
}
