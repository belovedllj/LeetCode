package Greedy;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        int maxNumber = A[0];
        int maxSumCurrent = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxSumCurrent < 0)
                maxSumCurrent = A[i];
            else maxSumCurrent += A[i];
            if (maxSumCurrent > maxNumber) 
                maxNumber = maxSumCurrent;
        }
        return maxNumber;
    }
}
