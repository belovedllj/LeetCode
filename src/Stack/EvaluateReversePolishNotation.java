package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length < 1) return -1;
        Stack<Integer> operends = new Stack<Integer>();
        for(String op : tokens) {
            if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                int sec = Integer.valueOf(operends.pop());
                int fir = Integer.valueOf(operends.pop());
                int res = 0;
                switch (op) {
                    case "+" : res = fir + sec; break;
                    case "-" : res = fir - sec; break;
                    case "*" : res = fir * sec; break;
                    case "/" : res = fir / sec; break;
                }
                operends.push(res);
            }
            else {
                operends.push(Integer.valueOf(op));
            }
        }
        return Integer.valueOf(operends.pop());
    }
}
