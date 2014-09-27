package Greedy;

public class MaximumProductSubarray_OwnMethod {
	public int maxProduct(int[] A) {
        if(A == null || A.length < 1)
            return 0;
        int max = Integer.MIN_VALUE, curPro = 1; // start with 1
        int firstNegIndex = -1;
        int proBeforefirstNegIndex = 0; // 3, -2, 4, 5, 6,-9, 1, -4  proBeforefirstNegIndex == -6
         
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) { // end of contiguous subarray
                curPro = 0;
                firstNegIndex = -1; 
            } else if (curPro == 0) { // new begining
                curPro = A[i];
                if(A[i] < 0) {
                    firstNegIndex = i;
                    proBeforefirstNegIndex = curPro; // found first neg pro
                }
            } else { // continue contiguous 
                curPro *= A[i];
                if(A[i] < 0 && firstNegIndex == -1) {
                    firstNegIndex = i;
                    proBeforefirstNegIndex = curPro; // found first neg pro
                }
                    
            }
            max = Math.max(max, curPro);
            if(curPro < 0 && firstNegIndex != -1 && firstNegIndex != i) { // another max, substract the neg before proBeforefirstNegIndex
                int tem = curPro / proBeforefirstNegIndex;
                max = Math.max(max, tem);
            }
        }
        
        return max;
    }
}
