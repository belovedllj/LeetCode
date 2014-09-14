package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII_DFS {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(num, new LinkedList<Integer>(), res, 0);
        return res;
    }
    private void helper(int[] num, List<Integer> curList, List<List<Integer>> res, int index) {
        res.add(new ArrayList<Integer>(curList));
        for(int i = index; i < num.length; i++) {
            if(i > index && num[i] == num[i - 1])
                continue;
            curList.add(num[i]);
            helper(num, curList, res, i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
