package Implementation;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        boolean isFirstRowZeros = false;
        boolean isFirstColZeros = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
            	isFirstRowZeros = true;
            	break;
            }            	
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
            	isFirstColZeros = true;
            	break;
            }            	
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        setMatrix(matrix, isFirstRowZeros, isFirstColZeros);
    }
    
    private void setMatrix(int[][] matrix, boolean isFirstRowZeros,
                            boolean isFirstColZeros) {
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for(int k = 1; k < matrix.length; k++) {
                    matrix[k][i] = 0;
                }
            }
        }
        for (int j = 1; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                for (int k = 1; k < matrix[0].length; k++) {
                    matrix[j][k] = 0;
                }
            }
        }
        if (isFirstRowZeros) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isFirstColZeros) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
