package Math;

import java.util.ArrayList;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        if(n < 1 || k < 1) return null;
        ArrayList<Integer> numberList = new ArrayList<Integer>(n);
        for(int i = 1; i <= n; i++) {
            numberList.add(i);
        }
        // set factorial of n
        int facto = 1;
        for(int i = 1; i <= n; i++) {
            facto *= i;
        }
        if (k > facto) return null;
        // 0 ----- n-1
        k--;
        String result = "";
        for(int i = n; i > 0; i--) {
            facto /= i;
            int curIndex = k / facto;
            k %= facto;
            result += numberList.get(curIndex);
            numberList.remove(curIndex);
        }
        return result;
    }
}
