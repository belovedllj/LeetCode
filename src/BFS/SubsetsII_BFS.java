package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII_BFS {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        int start = 0; // cope with duplicates
        res.add(new LinkedList<Integer>());
        for(int i = 0; i < num.length; i++) {
            int curSize = res.size();
            for(int j = start; j < curSize; j++) {
                List<Integer> temp = new LinkedList<Integer>(res.get(j));
                temp.add(num[i]);
                res.add(temp);
            }
            if(i < num.length - 1 && num[i] == num[i + 1])
                start = curSize; // don't need add duplicate into old set anymore, jump from start.
            else
                start = 0;
        }
        return res;
    }
}
