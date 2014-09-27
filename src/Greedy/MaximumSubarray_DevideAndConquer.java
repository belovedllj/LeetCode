package Greedy;

public class MaximumSubarray_DevideAndConquer {
	public int maxSubArray(int[] A) {
        if (A.length == 1) return A[0];
		return findMaxSubArray(A, 0, A.length - 1);
    }
    private int findMaxSubArray(int[] array, int left, int right) {
		if (left > right) return Integer.MIN_VALUE;
		if(right == left) return array[left]; 
		int mid = (right + left) / 2;
		int leftSum = array[mid], leftMaxSum = leftSum;
		int rightSum = array[mid + 1], rightMaxSum = rightSum;
		/*
		 *  1. max only on the left
		 *  2. max only on the right
		 *  3. max concanate right part of left and middle and left part of right
		 */
		for (int i = mid - 1; i >= left; i--) {
			leftSum += array[i];
			if (leftSum > leftMaxSum)
				leftMaxSum = leftSum;
		}
		for (int i = mid + 2; i <= right; i++) {
			rightSum += array[i];
			if (rightSum > rightMaxSum)
				rightMaxSum = rightSum;
		}
		int concanatedMaxSum = leftMaxSum + rightMaxSum;
		int onlyLeftMaxSum = findMaxSubArray(array, left, mid);
		int onlyRighMaxSum = findMaxSubArray(array, mid + 1, right);
		return Math.max(Math.max(onlyLeftMaxSum, onlyRighMaxSum), concanatedMaxSum);
	}
}
