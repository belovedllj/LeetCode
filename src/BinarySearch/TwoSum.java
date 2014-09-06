package BinarySearch;

import java.util.HashMap;
import java.util.Map;

// another solution using Binary Search
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
       if(numbers == null || numbers.length < 2) return null;
       int[] result = new int[2];
       Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
       map.put(numbers[0], 0);
       for(int i = 1; i < numbers.length; i++) {
           int aim = target - numbers[i];
           if(map.containsKey(aim)) {
               result[0] = map.get(aim) + 1;
               result[1] = i + 1;
               break;
           } else 
              map.put(numbers[i], i); 
       }
       return result;
   }
}
