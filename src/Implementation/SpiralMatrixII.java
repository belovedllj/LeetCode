package Implementation;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int number = 1;
        int[][] matrix = new int[n][n];
        int x = 0, y = 0;
        for (int i = n - 1; i >= 0; i -= 2) {
            if (i == 0) matrix[x][y] = number;
            else {
               // 4 line
                for (int j = 0; j < i; j++) 
                    matrix[x][y++] = number++;
                for (int j = 0; j < i; j++) 
                    matrix[x++][y] = number++;    
                for (int j = 0; j < i; j++) 
                    matrix[x][y--] = number++;    
                for (int j = 0; j < i; j++) {
                    if (j != i - 1) 
                        matrix[x--][y] = number++;
                    else
                        matrix[x][y++] = number++; 
                }   
            }
        }
        return matrix;
    }
}
