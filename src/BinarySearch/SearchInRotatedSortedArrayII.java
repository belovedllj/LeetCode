package BinarySearch;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {//wrong please see leetcode
        return helper(A, target, 0, A.length - 1);
    }
    
    private boolean helper(int[] A, int target, int low, int high) {
        if(low > high) return false;
        int mid = (low + high) / 2;
        if (target == A[mid]) return true;
        if (low == high) return false; // same element but A[mid] != target
        if (A[low] == A[high]) { // "13111"
            return helper(A, target, low, mid - 1) || helper(A, target, mid + 1, high);
        } else {
            if (A[low] <= A[mid]) {
            	if (target >= A[low] && target <= A[mid])
            		return helper(A, target, low, mid - 1);
            	else 
            		return helper(A, target, mid + 1, high);            	
            } else if (A[mid] <= A[high]) { 
            	if (target >= A[mid] && target <= A[high]) 
            		return helper(A, target, mid + 1, high);
            	else 
            		return helper(A, target, low, mid -1);
            }
        }
        return false;
    }
}
