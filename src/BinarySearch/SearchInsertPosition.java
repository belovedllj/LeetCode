package BinarySearch;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if (A.length <= 0) return 0;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            // Key is in a[lo..hi] or not present.
            int mid = low + (high - low) / 2;
            if      (target < A[mid]) high = mid - 1;
            else if (target > A[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }
}
