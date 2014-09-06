package BinarySearch;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        return helper(A, target, 0, A.length - 1);
    }
    private int helper(int[] A, int target, int low, int high) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if (target == A[mid]) return mid;

            if (A[low] <= A[mid]) {
            	if (target >= A[low] && target <= A[mid])
            		return helper(A, target, low, mid - 1);
            	else 
            		return helper(A, target, mid + 1, high);            	
            } else if (A[mid] < A[high]) { 
            	if (target >= A[mid] && target <= A[high]) 
            		return helper(A, target, mid + 1, high);
            	else 
            		return helper(A, target, low, mid -1);
            }
        return -1;
    }
}
