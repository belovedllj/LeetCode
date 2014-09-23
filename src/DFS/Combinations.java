package DFS;

import java.util.ArrayList;
import java.util.List;

// There is a non-recursive backward tracing solution on my LeetCode
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k < 1 || n < k)
        	return res;
        helper(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }
	private void helper(int n, int k, int pos, 
			List<List<Integer>> res, List<Integer> temp) {
		if(temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = pos; i <= n; i++) {
			temp.add(i);
			helper(n, k, i + 1, res, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
