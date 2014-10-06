package Pointer;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int lastValue = A[0];
        int newLength = 1;
        for(int i = 1; i < A.length; i++) {
            int currentValue = A[i];
            if(lastValue != currentValue) {
                A[newLength++] = A[i];
                lastValue = A[i];
            }
        }
        return newLength;
    }
}
