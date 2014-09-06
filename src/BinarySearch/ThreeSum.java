package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// multiple solutions
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        // 3Sum Closest
       if(num == null || num.length < 3) return new ArrayList<List<Integer>>(); 
   	Arrays.sort(num);
       int len = num.length;
       List<List<Integer>> res = new LinkedList<List<Integer>>();
       for(int i = 0; i < len - 2; i++) {
           int start = i + 1;
           int end = len - 1;
           while (start < end) {
        	   if(start > i + 1 && num[start] == num[start - 1]) {
                   start++;
                   continue;
               } 
               int sum = num[i] + num[start] + num[end];
               if (sum == 0) {
               	List<Integer> list = new ArrayList<Integer>(3);
               	Collections.addAll(list, num[i], num[start++], num[end--]);
               	res.add(list);                	
               } else if (sum < 0) {
                   start++;
               } else {
                   end--;
               }
           }
           while (i < len - 3 && num[i] == num[i + 1]) 
               i++;
       }
       return res;
   }
}
