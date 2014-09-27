package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {    	
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length < 1) return res;
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void combinationSumHelper(int[] candidates, int start, int target, 
    		ArrayList<Integer> path, List<List<Integer>> res) {
    	if (start < 0 || target < 0) return; 
        if (target == 0) {
        	ArrayList<Integer> newPath = new ArrayList<Integer>(path);
        	res.add(newPath);
        	return;
        } else {
        	for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
        		if(i > start && candidates[i] == candidates[i - 1])
        			continue;
        		path.add(candidates[i]);
        		combinationSumHelper(candidates, i, target - candidates[i], path, res);
        		path.remove(path.size() - 1);
        	}
        }        
    }
}
