package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets_DFS {
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        helper(S, new LinkedList<Integer>(), res, 0);
        return res;
    }
    private void helper(int[] S, List<Integer> curList, List<List<Integer>> res, int index) {
        res.add(new ArrayList<Integer>(curList));
        for(int i = index; i < S.length; i++) {
            curList.add(S[i]);
            helper(S, curList, res, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
