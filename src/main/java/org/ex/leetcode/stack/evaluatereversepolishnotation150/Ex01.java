package org.ex.leetcode.stack.evaluatereversepolishnotation150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/14 09:12
 */
public class Ex01 {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for (int i = 0; i < n ; i++){
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;

                }
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) return false;
        return true;
    }

    public static void main(String[] args) {
//        String[] tokens = new String[]{"2","1","+","3","*"};
//        String[] tokens = new String[]{"4","13","5","/","+"};
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
