package BinarySearch;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, 0, matrix.length * matrix[0].length - 1, matrix[0].length);
    }
    
    private boolean helper(int[][] matrix, int target, int low, int high, int rowNumber) {
        if (high < low) return false;
        int mid = (low + high) / 2;
        int x = mid / rowNumber;
        int y = mid % rowNumber;
        int currentVal = matrix[x][y];
        if (target > currentVal) {
            return helper(matrix, target, mid + 1, high, rowNumber);
        } else if (target < currentVal) {
            return helper(matrix, target, low, mid - 1, rowNumber);
        } else {
            return true;
        }
        
    }
}
