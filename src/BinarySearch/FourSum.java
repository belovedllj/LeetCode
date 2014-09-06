package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        if(num == null || num.length < 4) return new ArrayList<List<Integer>>(); 
    	Arrays.sort(num);
        int len = num.length;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for(int i = 0; i < len - 3; i++) {
        	for(int j = i + 1; j < len - 2; j++) {
        		 int start = j + 1;
                 int end = len - 1;
                 while (start < end) {
                     if(start > j + 1 && num[start] == num[start - 1]) {
                         start++;
                         continue;
                     }
                     int sum = num[i] + num[j] + num[start] + num[end];
                     if (sum == target) {
                     	List<Integer> list = new ArrayList<Integer>(4);
                     	Collections.addAll(list, num[i], num[j], num[start++], num[end--]);
                     	res.add(list);
                     } else if (sum < target) {
                         start++;
                     } else {
                         end--;
                     }
                 }
                 while (j < len - 3 && num[j] == num[j + 1]) 
                     j++;
        	}
        	while (i < len - 4 && num[i] == num[i + 1]) 
                i++;
           
        }
        return res;
    }
}
