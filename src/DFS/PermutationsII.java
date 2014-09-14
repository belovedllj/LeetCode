package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(num == null) return res;
        Arrays.sort(num);
        helper(num, new boolean[num.length], res, new LinkedList<Integer>());
        return res;
    }
    
    private void helper(int[] num, boolean[] used, List<List<Integer>> res, List<Integer> curList) {
        if(curList.size() == num.length) { // add into res
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(used[i] || (i > 0 && num[i] == num[i - 1] && !used[i - 1]))
                continue;
            curList.add(num[i]);
            used[i] = true;
            helper(num, used, res, curList);
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
}
