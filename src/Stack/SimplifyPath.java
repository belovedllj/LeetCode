package Stack;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        // http://blog.csdn.net/linhuanmars/article/details/23972563
        if(path == null || path.length() == 0) return "";
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < path.length(); i++) {
        	StringBuffer strBuf = new StringBuffer();
        	while(i < path.length() && path.charAt(i) != '/') {
        		strBuf.append(path.charAt(i));
        		i++;
        	}
        	if(strBuf.length() > 0) {
        		String str = strBuf.toString();
        		if(str.equals("..")) {
        			if(!stack.isEmpty()) {
        				stack.pop();
        			}
        		} else if(!str.equals(".")) {
        			stack.push(str);
        		}
        	}
        }
        if(stack.isEmpty()) {
        	return "/";
        }
        StringBuffer res = new StringBuffer();
        while(!stack.isEmpty()) {
        	res.insert(0, "/" + stack.pop());
        }
        return res.toString();
    }
}
