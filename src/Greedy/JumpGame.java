package Greedy;

public class JumpGame {
	public boolean canJump(int[] A) { 
		int max = 0;
	    for (int i = 0; i < A.length; i++) {
	        if (i > max) return false;
	        max = Math.max(i + A[i], max);
	    }
	    return true;
	}
}
