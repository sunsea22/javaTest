package leetcodeOJ;

import java.util.Stack;

/**
 * Created by Flyln on 16/8/9.
 * 20. Valid Parentheses
 * peek()方法： 查看栈顶对象而不移除它
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("([])"));
    }

    private boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); ++i) {
            if (!st.empty() && isMatch(st.peek(), s.charAt(i))) {
                st.pop();
            }
            else {
                st.push(s.charAt(i));
            }
        }
        if (st.empty()) {
            return true;
        }
        return false;
    }

    public boolean isMatch(char s, char p) {
        if ((s == '(' && p == ')') || (s == '{' && p == '}') || (s == '[' && p == ']')) {
            return true;
        }
        return false;
    }
}
