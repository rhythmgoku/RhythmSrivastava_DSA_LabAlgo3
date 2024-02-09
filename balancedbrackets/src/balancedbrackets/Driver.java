package balancedbrackets;

import java.util.Stack;

public class Driver {
	
    public static void main(String[] args) {
    	
        String input1 = "( [ [ { } ] ] )";
        String input2 = "( [ [ { } ] ] ) )";

        System.out.println("Sample Input 1: " + input1);
        System.out.println("Sample Output 1: " + checkBalancedBrackets(input1));

        System.out.println("Sample Input 2: " + input2);
        System.out.println("Sample Output 2: " + checkBalancedBrackets(input2));
    }

    public static String checkBalancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return "The entered String does not contain Balanced Brackets";
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return "The entered String does not contain Balanced Brackets";
                }
            }
        }

        if (stack.isEmpty()) {
            return "The entered String has Balanced Brackets";
        } else {
            return "The entered String does not contain Balanced Brackets";
        }
    }
}