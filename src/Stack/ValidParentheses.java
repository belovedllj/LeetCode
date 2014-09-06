package Stack;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
    	Stack<Character> charStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	if (cur == '(' || cur == '{' || cur == '[')
        		charStack.push(cur);
        	else {
        		if (charStack.isEmpty()) return false;
        		char popedChar;
        		switch (cur) {
        		    case ')' : 
        		    	popedChar = charStack.pop();
        		    	if (popedChar == '(') continue;
        		    	else return false;
        		    case '}' : 
        		    	popedChar = charStack.pop();
        		    	if (popedChar == '{') continue;
        		    	else return false;
        		    case ']' : 
        		    	popedChar = charStack.pop();
        		    	if (popedChar == '[') continue;
        		    	else return false;
        		    default : return false; // other characters
        		}        		
        	}        		
        }
        if (!charStack.isEmpty()) return false; // something left in stack;
        return true;
    }
}
