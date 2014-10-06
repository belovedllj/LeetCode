package Pointer;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int newArrayIndex = 0;
        for (int i = 0; i < A.length; i++) 
            if(A[i] != elem)
            	A[newArrayIndex++] = A[i];
        return newArrayIndex;
    }
}
