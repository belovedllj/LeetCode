package Pointer;
// counting sort
public class SortColors {
	public void sortColors(int[] A) {
        int i = -1, j = -1;
        for(int p = 0; p < A.length; p++) {
            int val = A[p];
            A[p] = 2;
            if(val == 0) {
                A[++j] = 1;
                A[++i] = 0;
            } else if (val == 1) {
                A[++j] = 1;
            }
        }
    }
}
