package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subset_BFS {
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        res.add(new LinkedList<Integer>());
        for(int i = 0; i < S.length; i++) {
            int curSize = res.size();
            for(int j = 0; j < curSize; j++) {
                List<Integer> temp = new LinkedList<Integer>(res.get(j));
                temp.add(S[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
