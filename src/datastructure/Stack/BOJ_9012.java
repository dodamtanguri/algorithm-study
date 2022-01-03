package datastructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int caseSize = sc.nextInt();
        for(int i = 0; i < caseSize; i++) {
            testCase(i);
        }
    }

    private static void testCase(int caseIndex) {
        String input = sc.next();
        int n = input.length();

        Brackets[] bracket = new Brackets[n];

        for(int i = 0; i < n; i++) {
            bracket[i] = new Brackets(i, input.charAt(i));
        }

        boolean isValid = isVaildBrackets(n, bracket);

        if(isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean isVaildBrackets(int n, Brackets[] bracket) {
        Stack<Brackets> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            Brackets brackets = bracket[i];
            if(brackets.type == Brackets.OPEN) {
                stack.push(brackets);
            } else if(brackets.type == Brackets.CLOSE) {
                if(stack.size() > 0 && stack.peek().type == Brackets.OPEN) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.size() > 0) {
            return false;
        }
         return true;
    }

    static class Brackets {
        public static final boolean OPEN = true;
        public static final boolean CLOSE = false;

        public final boolean type;
        public final int index;
        public Brackets(int index, boolean type) {
            this.index = index;
            this.type = type;
        }

        public Brackets(int index, char c) {
            this.index = index;
            if (c == '(') {
                this.type = OPEN;
            } else {
                this.type = CLOSE;
            }
        }

    }
}
