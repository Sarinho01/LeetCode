package easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();
        for (char c :s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') pStack.push(c);
            else {
                if(pStack.isEmpty()) return false;
                char pastC = pStack.pop();
                if(!(pastC == '(' && c == ')' || pastC == '{' && c == '}' || pastC == '[' && c == ']')) return false;
            }
        }

        return pStack.isEmpty();
    }
}
