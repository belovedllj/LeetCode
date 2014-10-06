package Pointer;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int lastValue = A[0];
        int newLength = 1;
        int couterDupNum = 0;
        for(int i = 1; i < A.length; i++) {
            int currentValue = A[i];
            if (lastValue == currentValue && couterDupNum == 0) {//first dup
                A[newLength++] = currentValue;
                couterDupNum++;
            } 
            if(lastValue != currentValue) {
                A[newLength++] = currentValue;
                lastValue = currentValue;
                couterDupNum = 0;
            }
        }
        return newLength;
    }
}
