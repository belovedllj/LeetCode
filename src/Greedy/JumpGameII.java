package Greedy;

public class JumpGameII {
	public int jump(int[] A) {
        if(A == null || A.length <= 1) return 0;
        int curMaxRange = 0, curRangeEnd = 0, step = 0;
        for(int i = 0; i < A.length; i++) { //must be a solution
            if (i > curRangeEnd) {
                curRangeEnd = curMaxRange;
                step++;
            }
            curMaxRange = Math.max(curMaxRange, i + A[i]);
        }
        return step;
	}
}
