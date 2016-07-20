package com.company.datastructures.expressionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by vnagpurkar on 7/17/16.
 */
public class ExpressionTree {

    // Expression tree is a binary tree in which each internal node corresponds to operator and
    // each leaf node corresponds to operand so create an expression tree for 3 + ((5+9)*2)
    // Postfix expression = 359+2*+
    public static ExpressionTreeNode<Character> createExpressionTreeUsingPostfix(String input) {

        Stack<ExpressionTreeNode<Character>> stack = new
                Stack<ExpressionTreeNode<Character>>();

        for (int i = 0; i < input.length(); i++) {
            ExpressionTreeNode<Character> node =
                    new ExpressionTreeNode<Character>(input.charAt(i));
            if (!isOperator(input.charAt(i))) {
                stack.push(node);
            } else {
                node.setRight(stack.pop());
                node.setLeft(stack.pop());
                stack.push(node);
            }
        }
        return stack.pop();
    }

    // Expression tree is a binary tree in which each internal node corresponds to operator and
    // each leaf node corresponds to operand
    public static void evaluateExpressionTree(ExpressionTreeNode<Character> root) {

        System.out.println("PostOrder Evaluation of 359+2*+ = " + postOrderEvaluation(root));
        System.out.println("InOrder Evaluation of 359+2*+ = " + inOrderEvalucation(root));
        System.out.println("PreOrder Evaluation of 359+2*+ = " + preOrderEvaluation(root));

    }

    // Convert infix expression to postfix expression
    public static void printInfixToPostfix(String infix) {

        System.out.println("Postfix expression:");
        System.out.print(infixToPostfix(infix));
    }

    private static String infixToPostfix(String infix) {

        Stack<Character> symbolStack = new Stack<Character>();
        Stack<Character> operandStack = new Stack<Character>();

        for(int i=0; i<infix.length(); i++) {

            char c = infix.charAt(i);
            if(isOperator(c)) {
                if(!symbolStack.isEmpty() &&
                        !canInsert(symbolStack.peek(), c)) {
                    operandStack.push(symbolStack.pop());
                }
                symbolStack.push(c);
            } else if(c == '(') {
                symbolStack.push(c);
            } else if(c == ')') {
                char temp = symbolStack.peek();
                while( temp!= '(') {
                    operandStack.push(symbolStack.pop());
                    temp = symbolStack.peek();
                }
                symbolStack.pop();
            } else {
                operandStack.push(c);
            }
        }
        while(!symbolStack.isEmpty()) {
            operandStack.push(symbolStack.pop());
        }
        char[] output = new char[operandStack.size()];
        int count = output.length - 1;
        while(!operandStack.isEmpty()) {
            output[count--] = operandStack.pop();
        }
        return String.valueOf(output);
    }

    public static void infixToPrefix(String infix) {

        //1. reverse the infix expression
        StringBuilder sb = new StringBuilder();
        for(int i=infix.length()-1; i>=0; i--) {
            sb.append(infix.charAt(i));
        }
        //2. perform the infixToPostfix
        String result = infixToPostfix(sb.toString());

        //3. reverse the result
        sb = new StringBuilder();
        for(int i=result.length()-1; i>=0; i--) {
            sb.append(result.charAt(i));
        }
        System.out.println("Prefix expression:");
        System.out.print(sb.toString());
    }

    private static boolean isOperator(char c) {

        if (c == '+' || c == '-' || c == '*'
                || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    private static int preOrderEvaluation(ExpressionTreeNode<Character> root) {

        if (root != null) {

            if (root.isLeaf()) {
                if (!isOperator(root.getData())) {
                    return root.getData() - '0';
                }
                return root.getData();
            }
            char operator = root.getData();
            int left = preOrderEvaluation(root.getLeft());
            int right = preOrderEvaluation(root.getRight());
            return calculate(left, operator, right);
        }
        return 0;
    }

    private static int inOrderEvalucation(ExpressionTreeNode<Character> root) {

        if (root != null) {

            if (root.isLeaf()) {

                if (!isOperator(root.getData())) {
                    return root.getData() - '0';
                }
                return root.getData();
            }

            return calculate(inOrderEvalucation(root.getLeft()), root.getData(), inOrderEvalucation(root.getRight()));
        }
        return 0;
    }

    private static int postOrderEvaluation(ExpressionTreeNode<Character> root) {

        if (root != null) {

            if (root.isLeaf()) {

                if (!isOperator(root.getData())) {
                    return root.getData() - '0';
                }
                return root.getData();
            }

            int left = postOrderEvaluation(root.getLeft());
            int right = postOrderEvaluation(root.getRight());

            return calculate(left, root.getData(), right);

        }
        return 0;
    }

    private static int calculate(int operand1, char operator, int operand2) {

        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        return result;
    }

    // Operator Presidence Order is given below
    // ^ has highest presidence, let's say 3
    // *, / has next higher presidence, let's say 2
    // +, - has next lowest presidence, let's say 1
    /*
    canInsert(operator1, operator2)
    returns true if operator2 <= operator1
                else returns false;
     */
    private static boolean canInsert(char operator1, char operator2) {

        if(operator1 == '(' || operator2 == ')') return true;
        Map<Character, Integer> characterPresidence = populatePresidence();
        int presidence1 = characterPresidence.get(operator1);
        int presidence2 = characterPresidence.get(operator2);

        if(presidence2 <= presidence1) {
            return true;
        }
        else {
            return false;
        }
    }

    private static Map<Character, Integer> populatePresidence() {

        Map<Character, Integer> characterPresidence = new HashMap<Character, Integer>();
        characterPresidence.put('^', 3);
        characterPresidence.put('*', 2);
        characterPresidence.put('/', 2);
        characterPresidence.put('+', 1);
        characterPresidence.put('/', 1);

        return characterPresidence;
    }


}


