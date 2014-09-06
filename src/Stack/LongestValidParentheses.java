package Stack;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        int max = 0, lastPos = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
            	stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    lastPos = i;
                } else {
                	stack.pop();
                    if(stack.isEmpty()) {
                        max = Math.max(max, i - lastPos);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
