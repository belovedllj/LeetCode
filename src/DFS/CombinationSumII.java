package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 1) return res;
        Arrays.sort(num);
        combinationSum2Helper(res, new ArrayList<Integer>(), num, 0, target);
        return res;
    }
    
    private void combinationSum2Helper(List<List<Integer>> res, 
                 ArrayList<Integer> curList, int[] num, int startPos, int targetLeft) {
        if(targetLeft < 0 || startPos < 0) return; // some error
        if(targetLeft == 0) {
            res.add(new ArrayList<Integer>(curList));
        }
        else {
            for(int i = startPos; i < num.length && num[i] <= targetLeft; i++) {
                if (i != startPos && num[i] == num[i-1]) continue;
                curList.add(num[i]);
                combinationSum2Helper(res, curList, num, i + 1, targetLeft - num[i]);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
