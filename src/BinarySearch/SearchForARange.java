package BinarySearch;

// more solutions
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
    	if(A.length < 1) return new int[]{-1, -1};
        int[] range = new int[2];
        range[0] = findLeftRightEdge(A, target, 0, A.length - 1, true);
        range[1] = findLeftRightEdge(A, target, 0, A.length - 1, false);
        return range;
    }
    private int findLeftRightEdge(int[] A, int target, int low, int high, boolean isFindingLeft) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target > A[mid]) return findLeftRightEdge(A, target, mid + 1, high, isFindingLeft);
        else if (target < A[mid]) return findLeftRightEdge(A, target, low, mid - 1, isFindingLeft);
        else {
            if (isFindingLeft) {
                if (mid == 0 || A[mid - 1] != target) return mid; //find left edge or left element not equal to target
                else return findLeftRightEdge(A, target, low, mid - 1, isFindingLeft);
            } else {
                if (mid == A.length - 1 || A[mid + 1] != target) return mid;
                else return findLeftRightEdge(A, target, mid + 1, high, isFindingLeft);
            }
        }
    }
}
