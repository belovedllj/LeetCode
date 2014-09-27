package Greedy;

public class TrappingRainWater {
	public int trap(int[] A) {
        int left = 0, right = A.length - 1, all = 0, block = 0, curLevel = 0;
        while (left <= right) {
            if (Math.min(A[right], A[left]) > curLevel) {
                all += (right - left + 1) * (Math.min(A[right], A[left]) - curLevel);
                curLevel = Math.min(A[right], A[left]);
            }
            if (A[left] < A[right])
                block += A[left++];
            else 
                block += A[right--];            
        }
        return all - block;
    }
}
