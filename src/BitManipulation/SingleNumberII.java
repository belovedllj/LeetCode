package BitManipulation;

public class SingleNumberII {
	public int singleNumber(int[] A) {
        if(A == null || A.length < 1) return -1;
        int[] bits = new int[32];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < 32; j++) {
                bits[j] += (A[i] >>> j) & 1;
            }
        }
        int res = 0;
        for(int k = 0; k < 32; k++) {
            res += (bits[k] % 3) << k;
        }
        return res;
    }
}
