package Implementation;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        // in the end A[0] = 1; A[1] = 2;...find the first missing one
        if(A == null || A.length == 0) return 1;
        for(int i = 0; i < A.length;) {
            if(A[i] != i + 1 && A[i] >= 1 &&
               A[i] <= A.length && A[i] != A[A[i] - 1]) {
                   //swap
                   //int temp = A[i];
                   //A[i] = A[A[i] - 1];
                   //A[temp - 1] = temp; // important!!!! change to temp
                   int temp = A[A[i] - 1];
                   A[A[i] - 1] = A[i];
                   A[i] = temp;
               }
            else 
                i++;
        }
        for(int j = 0; j < A.length; j++) {
            if (A[j] != j + 1)
                return j + 1;
        }
        return A.length + 1;
    }
}
