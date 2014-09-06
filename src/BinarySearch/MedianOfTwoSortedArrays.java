package BinarySearch;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
        //http://blog.csdn.net/linhuanmars/article/details/19905515
        if(A == null || B == null) return 0.0;
        if(A.length == 0 && B.length == 0) return 0.0;
        if((A.length + B.length) % 2 == 1) {
            return helper(A, B, 0, A.length, 0, B.length, (A.length + B.length) / 2 + 1);
        } else {
            return (helper(A, B, 0, A.length, 0, B.length, (A.length + B.length) / 2 + 1) +
                    helper(A, B, 0, A.length, 0, B.length, (A.length + B.length) / 2)) / 2;
        }
    }
    private double helper(int A[], int B[], int i, int i1, int j, int j1, int k) {
        int m = i1 - i;  
        int n = j1 - j;
        if(m > n)  
            return helper(B, A, j, j1, i, i1, k);
        if(m == 0)
            return B[j + k - 1];
        if(k == 1)
            return Math.min(A[i], B[j]);
        int posA = Math.min(k / 2, m);
        int posB = k - posA;
        if(A[i + posA - 1] == B[j + posB -1]) return A[i + posA - 1];
        else if(A[i + posA - 1] > B[j + posB -1])
            return helper(A, B, i, i1, j + posB, j1, k - posB);
        else 
            return helper(A, B, i + posA, i1, j, j1, k - posA);
    }
}
