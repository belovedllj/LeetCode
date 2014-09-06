package BinarySearch;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) { 
        Arrays.sort(num);
        int len = num.length;
        int minDiff = Integer.MAX_VALUE;
        int record = 0;
        for(int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                if(start > i + 1 && num[start] == num[start - 1]) {
                    start++;
                    continue;
                } 
                int sum = num[i] + num[start] + num[end];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    if (target - sum < minDiff) {
                        record = sum;
                        minDiff = target - sum;
                    }
                    start++;
                } else {
                    if (sum - target < minDiff) {
                        record = sum;
                        minDiff = sum - target;
                    }
                    end--;
                }
            }
            while (i < len - 3 && num[i] == num[i + 1]) 
                i++;
        }
        return record;
    }
}
