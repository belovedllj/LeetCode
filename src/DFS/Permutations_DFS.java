package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations_DFS {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(num == null) return res;
        helper(num, new boolean[num.length], res, new LinkedList<Integer>());
        return res;
    }
    private void helper(int[] num, boolean[] used, List<List<Integer>> res, List<Integer> curList) {
        if(curList.size() == num.length) { // add into res
            res.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(used[i])
                continue;
            curList.add(num[i]);
            used[i] = true;
            helper(num, used, res, curList);
            used[i] = false;
            curList.remove(curList.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> a = new ArrayList<Integer>(5);
    	System.out.println(a.size() + "   " + a);
    }
}
