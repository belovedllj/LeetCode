package Hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
    	int max = 1;
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
        	hashSet.add(num[i]);
        }
        for (int n : num) {
        	if (!hashSet.contains(n)) continue;
        	hashSet.remove(n);
        	int count = 1;
        	int left = n - 1;
        	int right = n + 1;
        	while (hashSet.contains(left)) {
        		count++;
        		hashSet.remove(left);
        		left--;
        	}
        	while (hashSet.contains(right)) {
        		count++;
        		hashSet.remove(right);
        		right++;
        	}
        	max = Math.max(max, count);
        }
        return max;
    }
}
