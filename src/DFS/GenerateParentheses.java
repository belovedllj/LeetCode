package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n < 1) return list;
        helper(n - 1, n, "(", list);
        return list;
    }
    private void helper(int lfNum, int rtNum, String str, List<String> list) {
        if (lfNum == 0 && rtNum == 0) {
            list.add(str);
            return;
        } 
        // create a totoally new String
        if(lfNum == 0) {
            helper(lfNum, rtNum - 1, str + ")", list);
        } else if (lfNum == rtNum){
            helper(lfNum - 1, rtNum, str + "(", list);
        } else {
            helper(lfNum, rtNum - 1, str + ")", list);
            helper(lfNum - 1, rtNum, str + "(", list);
        }
    }
}
