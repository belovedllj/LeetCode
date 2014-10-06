package MergeSort;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1, indexB = n - 1;
        for(int i = m + n - 1; i >= 0; i--) {
            if(indexA < 0) A[i] = B[indexB--];
            else if(indexB < 0) A[i] = A[indexA--];
            else {
                if(B[indexB] > A[indexA])
                    A[i] = B[indexB--];
                else 
                    A[i] = A[indexA--];
            }
        }
    }
}
