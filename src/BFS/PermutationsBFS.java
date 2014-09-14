package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsBFS {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(num == null) return res;
        List<Integer> curList = new ArrayList<Integer>(num.length);
        res.add(curList);
        for(int i = 0; i < num.length; i++) {
            List<List<Integer>> curRes = new LinkedList<List<Integer>>();
            for(List<Integer> list : res) {
                int curSize = res.size();
                for(int j = 0; j < curSize + 1; j++) {
                    List<Integer> tem = new LinkedList<Integer>(list);
                    tem.add(j, num[i]);
                    curRes.add(tem);
                }
            }
            res = curRes;
        }
        return res;
    }
	public static void main(String[] args) {
		
		new PermutationsBFS().permute(new int[]{0, 1});
	}
}
