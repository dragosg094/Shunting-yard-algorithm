package ShuntingYard_Pseudocode;

import java.util.ArrayList;

public class MyStackAlgorithm {


    public static int checkPreced(char c) {
        switch (c) {
            case '+':
            case '-':
                return 11;
            case '*':
            case '/':
                return 12;
            case '^':
                return 13;
        }
        return -1;
    }

    public static String checkSign(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return "left";
            case '^':
                return "right";
        }
        return null;
    }

    public static String postfix(String formula) {

        MyStack<Character> stack = new MyStack();


        ArrayList<Character> list = new ArrayList();


        for (int i = 0; i < formula.length(); i++) {
            list.add(formula.charAt(i));
        }

        Character o1;
        Character o2;

        StringBuilder postFix = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            o1 = list.get(i);
            if (Character.isDigit(o1)) {
                postFix.append(o1);
            } else if (!stack.empty() && o1 != '(' && o1 != ')') {

                o2 = stack.top();
                while (!stack.empty() && o2 != '(' && (checkPreced(o1) <= checkPreced(o2))) {
                    if (checkSign(o2).equals("right") && checkSign(o1).equals("left")) {
                        postFix.append(stack.pop());
                    } else if (checkSign(o2).equals("left") && checkSign(o1).equals("left")) {
                        postFix.append(stack.pop());
                    } else {
                        break;
                    }
                    o2 = stack.top();
                }
                stack.push(o1);

            } else if (o1 == '(') {
                stack.push(o1);

            } else if (o1 == ')') {
                try {
                    while (stack.top() != '(') {

                        postFix.append(stack.pop());
                    }
                    stack.pop();
                } catch (NullPointerException e) {
                    System.out.println("There is no left parentheses in the stack!");
                }
            } else {
                stack.push(o1);

            }
        }
        while (!stack.empty()) {
            if (stack.top() == '(') {
                System.out.println("There should not be a left parentheses in the stack!");
            }

            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    public static Integer infix(String formula) {

        MyStack<Character> stack = new MyStack();

        int result = 0;

        for (int i = 0; i < formula.length(); i++) {

            if (formula.charAt(i) != '+' && formula.charAt(i) != '-' && formula.charAt(i) != '*'
                    && formula.charAt(i) != '/'&& formula.charAt(i) != '^') {
                stack.push(formula.charAt(i));
            } else {
                int op1 = stack.pop() - '0';
                int op2 = stack.pop() - '0';
                if (formula.charAt(i) == '+') {

                    result = op2 + op1;
                    stack.push((char) (result + '0'));
                }
                if (formula.charAt(i) == '-') {
                    result = op2 - op1;
                    stack.push((char) (result + '0'));
                }else if (formula.charAt(i) == '*') {
                    result = op2 * op1;
                    stack.push((char) (result + '0'));
                } else if (formula.charAt(i) == '/') {
                    result = op2 / op1;
                    stack.push((char) (result + '0'));
                }else if (formula.charAt(i) == '^') {
                    result = (int)Math.pow(op2,op1);
                    stack.push((char) (result + '0'));
                }
            }


        }
        return stack.pop() - '0';
    }


}
