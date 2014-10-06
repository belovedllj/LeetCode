package BitManipulation;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int bit = 0;
        for(int i = 0; i < A.length; i++) {
            bit ^= A[i];
        }
        return bit;        
    }
}
